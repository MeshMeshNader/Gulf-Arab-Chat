package com.gulf.arabchat0.home.profile;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.greysonparrelli.permiso.Permiso;
import com.gulf.arabchat0.R;
import com.gulf.arabchat0.adapters.arabchat.OwnProfilePhotosAdapter;
import com.gulf.arabchat0.adapters.arabchat.OwnProfileSmallPhotosAdapter;
import com.gulf.arabchat0.app.Application;
import com.gulf.arabchat0.helpers.QuickActions;
import com.gulf.arabchat0.helpers.QuickHelp;
import com.gulf.arabchat0.home.HomeActivity;
import com.gulf.arabchat0.home.live.WalletActivity;
import com.gulf.arabchat0.home.payments.PaymentsActivity;
import com.gulf.arabchat0.home.popularity.PopularityActivity;
import com.gulf.arabchat0.home.search.UsersSearch;
import com.gulf.arabchat0.home.settings.SettingsActivity;
import com.gulf.arabchat0.home.settings.accountPreferences.AccountPreferencesActivity;
import com.gulf.arabchat0.home.uploads.UploadsActivity;
import com.gulf.arabchat0.models.arabchat.User;
import com.gulf.arabchat0.modules.circularimageview.CircleImageView;
import com.parse.ParseFile;

import java.util.ArrayList;
import java.util.Objects;


public class MyProfileFragment extends Fragment {

    public User mCurrentUser;

    private CircleImageView circleImageView;
    private TextView mNameAndAge;

    ArrayList<ParseFile> parseFiles;
    OwnProfileSmallPhotosAdapter ownProfilePhotosAdapter;

    RecyclerView mRecyclerView;

    private ImageView mPopularityImage;
    private TextView mPopularityText;

    private ImageView mProfileBannerImage, mAddPhotos, mCreditImage, mTokenImage;
    private TextView mCreditText, mTokenText;

    private TextView mCredits, mTokens, mProfileBannerText, mUserID;

    private CircleImageView mInvisibleMode;

    private View mCreditsView, mPopularityView, mProfileBannerView, mTokensView;

    FrameLayout myProfileBannerCardContainer;
    ConstraintLayout findFriendsCard, creditCardCard, photosCardCard, infoCardCard;


    public MyProfileFragment() {
        // Required empty public constructor
    }

    public static MyProfileFragment newInstance() {
        return new MyProfileFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle b) {
        super.onViewCreated(view, b);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile, container, false);

        circleImageView = v.findViewById(R.id.avatar);
        mNameAndAge = v.findViewById(R.id.myProfileNameAndAge);


        mInvisibleMode = v.findViewById(R.id.invisibleModeIcon);

        mCredits = v.findViewById(R.id.ownProfileElementOneSubtitle);
        mTokens = v.findViewById(R.id.ownProfileElementFourSubtitle);
        mCreditImage = v.findViewById(R.id.ownProfileElementOneImage);
        mTokenImage = v.findViewById(R.id.ownProfileElementFourImage);
        mCreditText = v.findViewById(R.id.ownProfileElementOneTitle);
        mTokenText = v.findViewById(R.id.ownProfileElementFourTitle);

        mAddPhotos = v.findViewById(R.id.popularity_promoBadgeRight);

        mPopularityImage = v.findViewById(R.id.ownProfileElementThreeImage);
        mPopularityText = v.findViewById(R.id.ownProfileElementThreeSubtitle);

        findFriendsCard = v.findViewById(R.id.myProfileFriendsCard);
        creditCardCard = v.findViewById(R.id.myProfileCreditCard);
        photosCardCard = v.findViewById(R.id.myProfilePhotosCard);
        infoCardCard = v.findViewById(R.id.myProfileInfoCard);

//        mSecondBigImage = v.findViewById(R.id.ownProfileElementTwoImage);
//        mSecondBigText = v.findViewById(R.id.ownProfileElementTwoTitle);
//        mSecondSmallText = v.findViewById(R.id.ownProfileElementTwoSubtitle);

        mProfileBannerImage = v.findViewById(R.id.myProfileBannerImage);
        mProfileBannerText = v.findViewById(R.id.myProfileBannerText);

        mCreditsView = v.findViewById(R.id.ownProfileElementOneClickableArea);
        mTokensView = v.findViewById(R.id.ownProfileElementFourClickableArea);
        //mInformationView = v.findViewById(R.id.ownProfileElementFiveClickableArea);
        mPopularityView = v.findViewById(R.id.ownProfileElementThreeClickableArea);
        //mSecondView = v.findViewById(R.id.ownProfileElementTwoClickableArea);
        mProfileBannerView = v.findViewById(R.id.myProfileBannerBackground);

        mUserID = v.findViewById(R.id.myProfileID);

        myProfileBannerCardContainer = v.findViewById(R.id.myProfileBannerCardContainer);
        //mMyInfoAvatarImage = v.findViewById(R.id.ownProfileElementFiveImage);

        mCurrentUser = User.getUser();


        if (mCurrentUser.getPrivacyAlmostInvisible()) {
            mInvisibleMode.setVisibility(View.VISIBLE);
        } else {
            mInvisibleMode.setVisibility(View.GONE);
        }


        if (mCurrentUser.getColGender().equals(User.GENDER_MALE)) {
            //mMyInfoAvatarImage.setImageResource(R.drawable.ic_boy);

            mCredits.setVisibility(View.VISIBLE);
            mCreditText.setVisibility(View.VISIBLE);
            mCreditImage.setVisibility(View.VISIBLE);
            mCreditsView.setVisibility(View.VISIBLE);
            mCredits.setText(String.valueOf(mCurrentUser.getCredits()));
            mTokens.setVisibility(View.GONE);
            mTokenText.setVisibility(View.GONE);
            mTokenImage.setVisibility(View.GONE);
            mTokensView.setVisibility(View.GONE);

            mCreditsView.setOnClickListener(v1 -> QuickHelp.goToActivityWithNoClean(getActivity(), PaymentsActivity.class, PaymentsActivity.ARABCHAT_PAYMENT_TYPE, PaymentsActivity.TYPE_3X_POPULAR));
            creditCardCard.setOnClickListener(v2 -> QuickHelp.goToActivityWithNoClean(getActivity(), PaymentsActivity.class, PaymentsActivity.ARABCHAT_PAYMENT_TYPE, PaymentsActivity.TYPE_3X_POPULAR));


        } else if (mCurrentUser.getColGender().equals(User.GENDER_FEMALE)) {
            //mMyInfoAvatarImage.setImageResource(R.drawable.ic_girl);


            mTokens.setVisibility(View.VISIBLE);
            mTokenText.setVisibility(View.VISIBLE);
            mTokenImage.setVisibility(View.VISIBLE);
            mTokensView.setVisibility(View.VISIBLE);
            mTokens.setText(String.valueOf(mCurrentUser.getTokens()));
            mCredits.setVisibility(View.GONE);
            mCreditText.setVisibility(View.GONE);
            mCreditImage.setVisibility(View.GONE);
            mCreditsView.setVisibility(View.GONE);


            mTokensView.setOnClickListener(v4 -> QuickHelp.goToActivityWithNoClean(getActivity(), WalletActivity.class));
            creditCardCard.setOnClickListener(v3 -> QuickHelp.goToActivityWithNoClean(getActivity(), WalletActivity.class));
        }

        findFriendsCard.setOnClickListener(v4 -> QuickHelp.goToActivityWithNoClean(getActivity(), UsersSearch.class));
        photosCardCard.setOnClickListener(v5 -> QuickHelp.goToActivityWithNoClean(getActivity(), UploadsActivity.class));
        infoCardCard.setOnClickListener(v6 -> QuickHelp.goToActivityWithNoClean(getActivity(), EditProfileActivity.class));


        String userID = getResources().getString(R.string.user_info_ID) + mCurrentUser.getUid();
        mUserID.setText(userID);
        mUserID.setOnClickListener(v7 -> QuickHelp.goToActivityWithNoClean(getActivity(), EditProfileActivity.class));


        mRecyclerView = v.findViewById(R.id.myProfile_photos_recycler);

        //Profile Images

        parseFiles = new ArrayList<>();
        ownProfilePhotosAdapter = new OwnProfileSmallPhotosAdapter(getActivity(), parseFiles, mCurrentUser);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.setReverseLayout(false);


        mRecyclerView.setAdapter(ownProfilePhotosAdapter);
        mRecyclerView.setItemViewCacheSize(12);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setBackgroundResource(R.color.white);
        mRecyclerView.setBackgroundColor(Color.WHITE);
        mRecyclerView.setLayoutManager(layoutManager);


        mPopularityImage.setImageResource(QuickHelp.getPopularityLevelIndicator(mCurrentUser));
        mPopularityText.setText(QuickHelp.getPopularityLevel(mCurrentUser));

//        if (mCurrentUser.getProfilePhotos().size() < 2) {
//
//            mSecondBigImage.setImageResource(R.drawable.ic_badge_add_photos);
//            mSecondBigText.setText(getString(R.string.photos_needed));
//            mSecondSmallText.setText(getString(R.string.add_photos));
//
//            mSecondView.setOnClickListener(v4 -> QuickHelp.goToActivityWithNoClean(getActivity(), UploadsActivity.class));
//
//        } else if (mCurrentUser.isPremium()) {
//
//            mSecondBigImage.setImageResource(R.drawable.ic_badge_feature_premium);
//            mSecondBigText.setText(getString(R.string.arabchat_premium));
//            mSecondSmallText.setText(getString(R.string.activate));
//
//            mSecondView.setOnClickListener(v1 -> QuickHelp.goToActivityWithNoClean(getActivity(), PaymentsActivity.class, PaymentsActivity.ARABCHAT_PAYMENT_TYPE, PaymentsActivity.TYPE_ARABCHAT_PREMIUM));
//
//        } else {
//
//            mSecondBigImage.setImageResource(R.drawable.ic_badge_add_photos);
//            mSecondBigText.setText(getString(R.string.get_more_visits));
//            mSecondSmallText.setText(getString(R.string.add_photos));
//
//            mSecondView.setOnClickListener(v4 -> QuickHelp.goToActivityWithNoClean(getActivity(), UploadsActivity.class));
//        }

        mPopularityView.setOnClickListener(v2 -> QuickHelp.goToActivityWithNoClean(getActivity(), PopularityActivity.class));
        mAddPhotos.setOnClickListener(v3 -> QuickHelp.goToActivityWithNoClean(getActivity(), UploadsActivity.class));
        //mInformationView.setOnClickListener(v4 -> QuickHelp.goToActivityWithNoClean(getActivity(), EditProfileActivity.class));


        if (mCurrentUser.isVerified()) {
            myProfileBannerCardContainer.setVisibility(View.INVISIBLE);
            mProfileBannerImage.setImageResource(R.drawable.ic_badge_feature_verification_verified);
            mProfileBannerView.setBackground(Application.getInstance().getResources().getDrawable(R.drawable.notification_background_rounded_with_border_verified));
            mProfileBannerText.setText(getString(R.string.verified));
            mProfileBannerText.setTextColor(Color.WHITE);

        } else {
            mProfileBannerImage.setImageResource(R.drawable.ic_badge_feature_verification_unverified);
            mProfileBannerView.setBackground(Application.getInstance().getResources().getDrawable(R.drawable.notification_background_rounded_with_border_unverified));
            mProfileBannerText.setText(getString(R.string.verify_account));
            mProfileBannerText.setTextColor(Color.WHITE);

            mProfileBannerView.setOnClickListener(v12 -> {

                if (mCurrentUser.getEmail() != null && !mCurrentUser.getEmail().isEmpty()) {

                    QuickHelp.showLoading(getActivity(), false);

                    mCurrentUser.setEmail(mCurrentUser.getEmail());
                    mCurrentUser.saveInBackground(e -> {

                        if (e == null) {

                            QuickHelp.hideLoading(getActivity());
                            QuickHelp.showToast(Objects.requireNonNull(getActivity()), getString(R.string.email_verification_sent), false);
                        } else {
                            QuickHelp.hideLoading(getActivity());
                            QuickHelp.showToast(Objects.requireNonNull(getActivity()), getString(R.string.error_ocurred), true);

                            QuickHelp.logoutForInvalidSession(getActivity(), e);
                        }
                    });

                } else {

                    QuickHelp.showToast(Objects.requireNonNull(getActivity()), getString(R.string.email_not_exist), true);
                }
            });

        }

        Permiso.getInstance().setActivity(Objects.requireNonNull(getActivity()));

        if (getActivity() != null) {

            ((HomeActivity) getActivity()).initializeToolBar(R.drawable.ic_new_settings, R.drawable.ic_new_edit_profile, HomeActivity.VIEW_TYPE_MY_PROFILE);

            mNameAndAge.setOnClickListener(v1 -> QuickActions.showProfile(getActivity(), mCurrentUser, true));
            circleImageView.setOnClickListener(v1 -> QuickActions.showProfile(getActivity(), mCurrentUser, true));
        }

        setHasOptionsMenu(true);


        return v;

    }

    public void getIconLeft(Activity activity) {

        QuickHelp.goToActivityWithNoClean(activity, SettingsActivity.class);

    }

    public void getIconRight(Activity activity) {

        QuickHelp.goToActivityWithNoClean(activity, AccountPreferencesActivity.class);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Objects.requireNonNull(getActivity()).onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        Permiso.getInstance().setActivity(Objects.requireNonNull(getActivity()));

        if (mCurrentUser != null) {

            mCurrentUser.fetchInBackground();

            QuickHelp.getAvatars(mCurrentUser, circleImageView);

            if (mCurrentUser.getColGender().equals(User.GENDER_MALE)) {
                mCredits.setText(String.valueOf(mCurrentUser.getCredits()));
            } else if (mCurrentUser.getColGender().equals(User.GENDER_FEMALE)) {
                mTokens.setText(String.valueOf(mCurrentUser.getTokens()));
            }


            if (mCurrentUser.getBirthDate() != null) {

                mNameAndAge.setText(String.format(" %s, %s", mCurrentUser.getColFullName(), QuickHelp.getAgeFromDate(mCurrentUser.getBirthDate())));
            } else mNameAndAge.setText(mCurrentUser.getColFullName());


            parseFiles.clear();
            parseFiles.addAll(mCurrentUser.getProfilePhotos());
            ownProfilePhotosAdapter.notifyDataSetChanged();

            mRecyclerView.scrollToPosition(mCurrentUser.getAvatarPhotoPosition());
        }
    }
}