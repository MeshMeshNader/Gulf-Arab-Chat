package com.gulf.arabchat0.home.settings;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.gulf.arabchat0.R;
import com.gulf.arabchat0.adapters.others.LanguageAdapter;
import com.gulf.arabchat0.app.Config;
import com.gulf.arabchat0.auth.WelcomeActivity;
import com.gulf.arabchat0.helpers.QuickHelp;
import com.gulf.arabchat0.home.settings.accountPreferences.AccountPreferencesActivity;
import com.gulf.arabchat0.home.settings.about.AboutActivity;
import com.gulf.arabchat0.home.settings.account.AccountActivity;
import com.gulf.arabchat0.home.settings.basicInfo.BasicInfoActivity;
import com.gulf.arabchat0.models.arabchat.User;
import com.gulf.arabchat0.models.others.LanguageModel;
import com.gulf.arabchat0.utils.Tools;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    Toolbar toolbar;

    User mCurrentUser;

    LinearLayout mBasicInfo, mAccount, mAccountLang, mAccountSignOut, mAccountPreference, mHelpCenter, mAbout, mBlockedUsers;

    TextView mAccountEmail, mBlockedUsersText;

    LanguageAdapter languageAdapter;
    ArrayList<LanguageModel> languageModels;

    BottomSheetDialog sheetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        toolbar = findViewById(R.id.toolbar);

        mAccountEmail = findViewById(R.id.account_email);

        mBasicInfo = findViewById(R.id.basic_info);
        mAccount = findViewById(R.id.account);
        mAccountPreference = findViewById(R.id.account_preference);
        mAccountLang= findViewById(R.id.account_lang);
        mAccountSignOut= findViewById(R.id.sign_out);
        mHelpCenter = findViewById(R.id.help_center);
        mAbout = findViewById(R.id.about);
        mBlockedUsers = findViewById(R.id.blocked_users);
        mBlockedUsersText = findViewById(R.id.blocked_users_text);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.Settings));
        getSupportActionBar().setElevation(4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        mCurrentUser = (User) User.getCurrentUser();

        if (mCurrentUser != null){

            if (!mCurrentUser.getEmail().isEmpty()){

                mAccountEmail.setText(mCurrentUser.getEmail());

            } else mAccountEmail.setVisibility(View.GONE);


            if (mCurrentUser.getBlockedUsers() != null && mCurrentUser.getBlockedUsers().size() > 0){

                mBlockedUsers.setEnabled(true);
                mBlockedUsersText.setTextColor(getResources().getColor(R.color.black));

            } else {

                mBlockedUsers.setEnabled(false);
                mBlockedUsersText.setTextColor(getResources().getColor(R.color.gray_24));
            }
        }

        mBasicInfo.setOnClickListener(v -> goToBasicInfo());
        mAccount.setOnClickListener(v -> goToAccount());
        mAccountPreference.setOnClickListener(v -> goToAccountPreference());
        mAccountLang.setOnClickListener(v -> openLanguageChooser());
        mAccountSignOut.setOnClickListener(v -> signOut());
        mHelpCenter.setOnClickListener(v -> goToHelpCenter());
        mAbout.setOnClickListener(v -> goToAbout());
        mBlockedUsers.setOnClickListener(v -> goToBlockedUsers());

    }

    public void signOut(){

        QuickHelp.showLoading(this, false);

        QuickHelp.removeUserToInstallation();

        mCurrentUser.deleteInstallation();
        mCurrentUser.saveInBackground(e -> {

            if (e == null){

                ParseUser.logOutInBackground(e1 -> {

                    if (e1 == null){

                        QuickHelp.hideLoading(this);
                        QuickHelp.showToast(this, getString(R.string.profile_account_signout_success), false);
                        QuickHelp.goToActivityLogout(this, WelcomeActivity.class);

                    } else {
                        QuickHelp.hideLoading(this);
                        QuickHelp.showToast(this, getString(R.string.error_ocurred), true);
                    }
                });

            } else {

                QuickHelp.hideLoading(this);
                QuickHelp.showToast(this, getString(R.string.error_ocurred), true);
            }
        });

    }

    private void openLanguageChooser() {
        languageModels = new ArrayList<>();
        languageAdapter = new LanguageAdapter(this, languageModels);

        sheetDialog = new BottomSheetDialog(this, R.style.AppBottomSheetDialogTheme);
        sheetDialog.setContentView(R.layout.include_langauges);
        sheetDialog.setCancelable(true);
        sheetDialog.setCanceledOnTouchOutside(true);
        sheetDialog.getBehavior().setState(BottomSheetBehavior.STATE_EXPANDED);

        RecyclerView recyclerView = sheetDialog.findViewById(R.id.lang_rv);

        assert recyclerView != null;

        LinearLayoutManager layoutManagerSpotlight = new LinearLayoutManager(this);
        layoutManagerSpotlight.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setAdapter(languageAdapter);
        recyclerView.setItemViewCacheSize(12);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setBackgroundResource(R.color.white);
        recyclerView.setBackgroundColor(Color.WHITE);
        recyclerView.setLayoutManager(layoutManagerSpotlight);

        languageModels.clear();
        languageModels.addAll(QuickHelp.getLanguages());
        languageAdapter.notifyDataSetChanged();

        //sheetDialog.setOnDismissListener(dialogInterface -> anyActionSelected = null);

        if (sheetDialog != null && !sheetDialog.isShowing()){
            sheetDialog.show();
        }
    }


    public void goToBasicInfo(){

        QuickHelp.goToActivityWithNoClean(this, BasicInfoActivity.class);
    }

    public void goToAccount(){

        QuickHelp.goToActivityWithNoClean(this, AccountActivity.class);

    }

    public void goToAccountPreference(){

        QuickHelp.goToActivityWithNoClean(this, AccountPreferencesActivity.class);
    }

    public void goToHelpCenter(){

        QuickHelp.goToActivityWithNoClean(this, WebUrlsActivity.class, WebUrlsActivity.WEB_URL_TYPE, Config.HELP_CENTER);
    }

    public void goToAbout(){

        QuickHelp.goToActivityWithNoClean(this, AboutActivity.class);

    }

    public void goToBlockedUsers(){

        QuickHelp.goToActivityWithNoClean(this, BlockedUsersActivity.class);
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