package com.gulf.arabchat0.app;


public class Config {

    // Parse Server
    public static final String SERVER_URL = "https://parseapi.back4app.com/";
    public static final String LIVE_QUERY_URL = "wss://arabchatii.b4a.app/";
    static final String SERVER_APP_ID = "mTjrvBCd3gMwdbMqlM1lTx6aYvRm6LMPNJCM14PN";
    static final String SERVER_CLIENT_KEY = "bfJaCIiEoJNXWXDL0Povkp7lzV4KY1jfSup6OD9w";

    // Push notifications
    public static final String CHANNEL = "global";

    // Agora API
    public static final String AGORA_APP_ID = "f087cd018335428796c55cff865ada7e";

    // FlutterWave
    public static final String FLUTTERWAYE_PUBLISH_KEY = "FLWPUBK-b3fdfdfd9a3d68ecfadbace19b569-X";
    public static final String FLUTTERWAYE_ENCRYPTION_KEY = "92a7ebb56ffcfdfdfdc313";

    // PayPal
    public static final String PAYPAL_CLIENT_ID = "AeDV4Lr7Byih9L7tccceD18fdfdfdzql6ibEdzP3xc-KYSAQnxsbYen2pI7U2ES5iKrq3YEAy";


    // Instagram API
    public static final String INSTAGRAM_APP_ID = "359868688647307";
    public static final String INSTAGRAM_APP_SECRET = "e5b5e2e2e82a45061a31ce6c9ddc05ae";
    public static final String INSTAGRAM_REDIRECT_URI = "https://www.instagram.com/gulf_arab_chat";

    // Google Admob
    static final String HOME_BANNER_ADS = "ca-app-pub-5718962829212392/6612851440";
    static final String REWARDED_ADS= "ca-app-pub-5718962829212392/7538920300";
    static final String NEARBY_NATIVE_ADS = "ca-app-pub-3357491191456114/8542466089";
    static final String ENCOUNTERS_NATIVE_ADS = "ca-app-pub-5718962829212392/6608982014";

    // Google Play In-app Purchases IDs
    public static final String CREDIT_500= "arabchat.500.credits"; // $1 // Full Price
    public static final String CREDIT_2000 = "arabchat.2000.credits"; // $4 // Full Price
    public static final String CREDIT_10000 = "arabchat.10000.credits"; // $19 // %5
    public static final String CREDIT_20000 = "arabchat.20000.credits"; // $34 // %15 // most popular
    public static final String CREDIT_40000 = "arabchat.40000.credits"; // $72 // %10
    public static final String CREDIT_80000 = "arabchat.80000.credits"; // $136 // %15
    public static final String CREDIT_100000 = "arabchat.100000.credits"; // $160 // %20


    public static final String PAY_LIFETIME = "arabchat.pay.lifetime";

    //Google Play In-app Subscription IDs
    public static final String SUBS_3_MONTHS = "arabchat.3.months"; // 8
    public static final String SUBS_1_WEEK = "arabchat.1.week"; // 1
    public static final String SUBS_1_MONTH = "arabchat.1.month"; // 3
    public static final String SUBS_6_MONTHS = "arabchat.6.months"; // 15

    // Web links for help, privacy policy and terms of use.
    public static final String HELP_CENTER = "https://www.instagram.com/gulf_arab_chat";
    public static final String PRIVACY_POLICY = "https://arab-chat-0.flycricket.io/privacy.html";
    public static final String TERMS_OF_USE = "https://arab-chat-0.flycricket.io/terms.html";
    public static final String TERMS_OF_USE_IN_APP = "https://arab-chat-0.flycricket.io/terms.html";

    // Withdraw tokens to PayPal
    public static final int MinTokenWithdraw = 200; // Minimum amount of tokens allowed to exchange
    public static final int WithdrawExchangeRate = 100; // 100 tokens equal to 1 USD

    // Enable or disable logins system
    public static final boolean EMAIL_LOGIN = true;
    public static final boolean PHONE_LOGIN = true;
    public static final boolean GOOGLE_LOGIN = true;
    public static final boolean FACEBOOK_LOGIN = true;
    // Enable or Disable Payment Systems
    public static final boolean PAYPAL_ENABLED = true;
    public static final boolean FLUTTER_WAVE_ENABLED = true;
    // Extra features to add in payment methods
    public static final boolean PAYPAL_CREDIT_CARD_ENABLED = false;
    // Exchange your tokens
    public static final int MinTokenExchange = 100; // Minimum amount of tokens allowed to exchange
    public static final int TokenExchangeRate = 2; // 2 tokens equal to 1 Credit

    // Enable or Disable paid messages.
    public static final boolean isPaidMessagesActivated = false;

    // Credits needed to activate features
    public static int TYPE_RISE_UP = 1000;
    public static int TYPE_GET_MORE_VISITS = 1000;
    public static int TYPE_ADD_EXTRA_SHOWS = 1000;
    public static int TYPE_SHOW_IM_ONLINE = 1000;
    public static int TYPE_3X_POPULAR = 1000;

    // Amount of days to activate features
    public static int DAYS_TO_ACTIVATE_FEATURES = 7;

    // Enable or Disable Ads and Premium.
    public static final boolean isAdsActivated = true;
    public static final boolean isPremiumEnabled = true;
    public static final boolean isNearByNativeAdsActivated = false;
    public static final boolean isEncountersNativeAdsActivated = false;

    // Encounters crush
    public static final boolean isCrushCreditNeeded = true;
    public static final int CrushCreditNeeded = 50;
    public static final boolean isCrushAdsEnabled = true;
    public static final int CrushAdsLimitPerDay = 5;

    // Application setup
    public static final String bio = "Hey! i'm using Gulf Arab Chat!";
    public static final int WelcomeCredit = 100;
    public static final int MinimumAgeToRegister = 18;
    public static final int MaximumAgeToRegister = 80;
    public static final int MaxUsersNearToShow = 100;
    public static final int DistanceForRealBadge = 50;
    public static final int DistanceForRealKm = 1000;
    public static final int MinDistanceBetweenUsers = 20;
    public static final int MaxDistanceBetweenUsers = 1000;
    public static final double DistanceBetweenUsersLive = 1000;
    public static final boolean ShowBlockedUsersOnQuery = true;
    public static final boolean isVideoCallEnabled = true;
    public static final boolean isVoiceCallEnabled = true;
    public static final int ShowNearbyNativeAdsAfter = 15;
    public static final int ShowEncountersNativeAdsAfter = 2;
    public static final int freeMessagesInTotal = 10;
    public static final int freeMessagesPerDay = 5;

    // Enable or Disable Fake messages.
    public static final boolean isFakeMessagesActivated = true;
    public static final String defaultFakeMessage = "كيفك يا قمر ؟";
}