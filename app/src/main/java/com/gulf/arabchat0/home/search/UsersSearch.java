package com.gulf.arabchat0.home.search;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gulf.arabchat0.R;
import com.gulf.arabchat0.adapters.arabchat.UsersNearAdapter;
import com.gulf.arabchat0.app.Config;
import com.gulf.arabchat0.auth.WelcomeActivity;
import com.gulf.arabchat0.helpers.QuickHelp;
import com.gulf.arabchat0.models.arabchat.User;
import com.gulf.arabchat0.utils.ParseRecyclerQueryAdapter;
import com.gulf.arabchat0.utils.StaggeredGridLayoutManagerWrapper;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ui.widget.ParseQueryAdapter;

import java.util.ArrayList;
import java.util.List;

public class UsersSearch extends AppCompatActivity {


    private User mCurrentUser;


    SearchView mSearchView;
    Toolbar toolbar;

    private SwipeRefreshLayout swipeRefreshLayout;
    private UsersNearAdapter mUsersNearAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayout mEmptyView, mEmptyLayout, mLoadingLayout;

    private TextView mErrorDesc, mErrorTitle;

    private ImageView mErrorImage;

    String q, lastQ = "";
    String regex = "\\d{5}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_search);

        initViews();

    }

    private void initViews() {
        mSearchView = findViewById(R.id.searching_bar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_search);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        swipeRefreshLayout = findViewById(R.id.search_swiperefreshlayout);
        mRecyclerView = findViewById(R.id.search_rvChat);

        mEmptyView = findViewById(R.id.search_empty_view);
        mEmptyLayout = findViewById(R.id.search_empty_layout);
        mLoadingLayout = findViewById(R.id.search_loading);


        mErrorImage = findViewById(R.id.search_image);
        mErrorTitle = findViewById(R.id.search_title);
        mErrorDesc = findViewById(R.id.search_brief);

        mCurrentUser = User.getUser();
        mCurrentUser.fetchInBackground();

        swipeRefreshLayout.setRefreshing(false);

        setLoading();

        mUsersNearAdapter = new UsersNearAdapter(getQueryFactory(""), true, UsersSearch.this);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                lastQ = query;
                q = query;
                mUsersNearAdapter = new UsersNearAdapter(getQueryFactory(q), true, UsersSearch.this);
                mUsersNearAdapter.notifyDataSetChanged();
                mRecyclerView.setAdapter(mUsersNearAdapter);


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                lastQ = newText;
                mUsersNearAdapter = new UsersNearAdapter(getQueryFactory(newText), true, UsersSearch.this);
                mUsersNearAdapter.notifyDataSetChanged();
                mRecyclerView.setAdapter(mUsersNearAdapter);


                return false;
            }
        });


        mUsersNearAdapter.addOnQueryLoadListener(new ParseRecyclerQueryAdapter.OnQueryLoadListener<User>() {
            @Override
            public void onLoaded(List<User> usersNear, ParseException e) {

                if (usersNear != null) {

                    if (usersNear.size() > 0) {

                        hideLoading(true);

                    } else {

                        hideLoading(false);

                        mEmptyLayout.setVisibility(View.VISIBLE);

                        mLoadingLayout.setVisibility(View.GONE);
                        mEmptyView.setVisibility(View.VISIBLE);

                        mErrorImage.setImageResource(R.drawable.ic_users);
                        mErrorTitle.setText(R.string.you_dont_have_any_people_near);
                        mErrorDesc.setText(R.string.no_one_found_update);
                    }
                } else {

                    hideLoading(false);

                    if (e.getCode() == ParseException.CONNECTION_FAILED) {

                        mErrorImage.setImageResource(R.drawable.ic_blocker_large_connection_grey1);
                        mErrorTitle.setText(R.string.not_internet_connection);
                        mErrorDesc.setText(R.string.settings_no_inte);

                    } else if (e.getCode() == ParseException.INVALID_SESSION_TOKEN) {

                        User.logOut();
                        QuickHelp.goToActivityAndFinish(UsersSearch.this, WelcomeActivity.class);

                    } else {

                        mErrorImage.setImageResource(R.drawable.ic_close);
                        mErrorTitle.setText(R.string.error_ocurred);
                        mErrorDesc.setText(e.getLocalizedMessage());

                    }
                }

                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override
            public void onLoading() {

            }
        });


        mRecyclerView.setAdapter(mUsersNearAdapter);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManagerWrapper(3, StaggeredGridLayoutManager.VERTICAL);

        mRecyclerView.setItemViewCacheSize(5);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setBackgroundResource(R.color.white);
        mRecyclerView.setBackgroundColor(Color.WHITE);
        mRecyclerView.setLayoutManager(layoutManager);

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.setOnRefreshListener(() -> {

            swipeRefreshLayout.setRefreshing(true);
            loadUsers();


        });


    }


    private void loadUsers() {
        mUsersNearAdapter = new UsersNearAdapter(getQueryFactory(lastQ), true, UsersSearch.this);
        mUsersNearAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mUsersNearAdapter);
        swipeRefreshLayout.setRefreshing(false);
    }

    public ParseQueryAdapter.QueryFactory getQueryFactory(String q) {

        ParseQueryAdapter.QueryFactory<User> factory = () -> {

            ArrayList<User> userArrayList = new ArrayList<>();
            userArrayList.add(mCurrentUser);

            ParseQuery<User> UsersNearQuery = User.getUserQuery();
            UsersNearQuery.whereNotEqualTo(User.COL_ID, mCurrentUser.getObjectId());
            if (q.matches(regex))
                UsersNearQuery.whereEqualTo(User.UID, Integer.valueOf(q)); // Only show users with id
            else
                UsersNearQuery.whereContains(User.COL_USERNAME, q); // Only show users with user name

            UsersNearQuery.whereNotEqualTo(User.PRIVACY_ALMOST_INVISIBLE, true);
            UsersNearQuery.whereNotContainedIn(User.BLOCKED_USERS, userArrayList);
            UsersNearQuery.whereNotEqualTo(User.USER_BLOCKED_STATUS, true);

            if (!Config.ShowBlockedUsersOnQuery && mCurrentUser.getBlockedUsers() != null && mCurrentUser.getBlockedUsers().size() > 0) {

                List<String> blockedUserId = new ArrayList<>();

                for (User user : mCurrentUser.getBlockedUsers()) {
                    if (!blockedUserId.contains(user.getObjectId())) {
                        blockedUserId.add(user.getObjectId());
                    }
                }

                UsersNearQuery.whereNotContainedIn(User.COL_ID, blockedUserId);
            }


            UsersNearQuery.orderByAscending(User.VIP_MOVE_TO_TOP);


            UsersNearQuery.orderByDescending(User.CREDIT_AMOUNT);
            return UsersNearQuery;
        };

        return factory;
    }


    private void setLoading() {

        mEmptyLayout.setVisibility(View.VISIBLE);
        mEmptyView.setVisibility(View.GONE);
        mLoadingLayout.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }

    private void hideLoading(boolean isLoaded) {

        if (isLoaded) {
            mEmptyLayout.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);

        } else {
            mEmptyView.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }
        mLoadingLayout.setVisibility(View.GONE);
    }

}