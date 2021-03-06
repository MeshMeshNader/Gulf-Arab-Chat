package com.gulf.arabchat0.home.settings;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gulf.arabchat0.R;
import com.gulf.arabchat0.adapters.arabchat.BlockedUsersAdapter;
import com.gulf.arabchat0.models.arabchat.User;
import com.gulf.arabchat0.utils.Tools;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Objects;

public class BlockedUsersActivity extends AppCompatActivity {

    Toolbar toolbar;

    User mCurrentUser;

    ArrayList<User> mBlockedUsers;
    BlockedUsersAdapter mBlockedUsersAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocked_users);

        toolbar = findViewById(R.id.toolbar);

        mCurrentUser = (User) ParseUser.getCurrentUser();

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.blocked_users));
        getSupportActionBar().setElevation(4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        mRecyclerView = findViewById(R.id.rvBlockedUsers);

        mBlockedUsers = new ArrayList<>();
        mBlockedUsersAdapter = new BlockedUsersAdapter(this, mBlockedUsers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mRecyclerView.setAdapter(mBlockedUsersAdapter);
        mRecyclerView.setItemViewCacheSize(12);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setBackgroundResource(R.color.white);
        mRecyclerView.setBackgroundColor(Color.WHITE);
        mRecyclerView.setLayoutManager(layoutManager);

        if (mCurrentUser != null && mCurrentUser.getBlockedUsers().size() > 0){

            mBlockedUsers.addAll(mCurrentUser.getBlockedUsers());
            mBlockedUsersAdapter.notifyDataSetChanged();
        }

    }

    public void getBlockedUserList(){

        ParseQuery<User> userParseQuery = User.getUserQuery();
        userParseQuery.whereContainsAll(User.KEY_OBJECT_ID, mCurrentUser.getBlockedUsers());
        userParseQuery.findInBackground((userList, e) -> {

            if (e == null && userList.size() > 0){

                mBlockedUsers.clear();
                mBlockedUsers.addAll(userList);
                mBlockedUsersAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}