package com.gulf.arabchat.modules.instagram;


import com.gulf.arabchat.app.Application;

import java.util.List;

public class AuthInstagram {

    public static void connectInstagram(List<String> scopes, AuthCallback authCallback){

        AuthDataHolder.getInstance().instagramAuthData = new AuthData(scopes, authCallback);

        InstagramAuthActivity.start(Application.getInstance());
    }

    public static void  disconnectInstagram (AuthCallback authCallback){

        AuthDataHolder.getInstance().instagramAuthData = null;
        CookiesUtils.clearCookies(Application.getInstance());
    }

}
