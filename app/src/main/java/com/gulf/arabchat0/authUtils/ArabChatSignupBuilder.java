package com.gulf.arabchat0.authUtils;


import android.content.Context;
import android.content.Intent;


import com.parse.ui.login.ParseLoginConfig;

import java.util.Collection;

public class ArabChatSignupBuilder {

    private Context context;
    private ParseLoginConfig config = new ParseLoginConfig();

    public ArabChatSignupBuilder(Context context) {
        this.context = context;
    }

    /**
     * Customize the logo shown in the login screens
     *
     * @param id
     *     The resource ID for the logo drawable.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setAppLogo(int id) {
        config.setAppLogo(id);
        return this;
    }

    /**
     * Whether to show Parse username/password UI elements on the login screen,
     * and the associated signup screen. Default is false.
     *
     * @param enabled
     *     Whether to show the username/password login.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseLoginEnabled(boolean enabled) {
        config.setParseLoginEnabled(enabled);
        return this;
    }

    /**
     * Customize the text of the Parse username/password login button.
     *
     * @param text
     *     The text to display on the button.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseLoginButtonText(CharSequence text) {
        config.setParseLoginButtonText(text);
        return this;
    }

    /**
     * Customize the text of the Parse username/password login button.
     *
     * @param id
     *     The resource ID for the text to display on the login button.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseLoginButtonText(int id) {
        return setParseLoginButtonText(maybeGetString(id));
    }

    /**
     * Customize the text on the Parse signup button.
     *
     * @param text
     *     The text to display on the button.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseSignupButtonText(CharSequence text) {
        config.setParseSignupButtonText(text);
        return this;
    }

    /**
     * Customize the text on the Parse signup button.
     *
     * @param id
     *     The resource ID for the text to display on the button.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseSignupButtonText(int id) {
        return setParseSignupButtonText(maybeGetString(id));
    }

    /**
     * Customize the text for the link to resetting the user's forgotten password.
     *
     * @param text
     *     The text to display on the link.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseLoginHelpText(CharSequence text) {
        config.setParseLoginHelpText(text);
        return this;
    }

    /**
     * Customize the text for the link to resetting the user's forgotten password.
     *
     * @param id
     *     The resource ID for the text to display on the link.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseLoginHelpText(int id) {
        return setParseLoginHelpText(maybeGetString(id));
    }

    /**
     * Customize the toast shown when the user enters an invalid username/password
     * pair.
     *
     * @param text
     *     The text to display on the toast.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseLoginInvalidCredentialsToastText(
            CharSequence text) {
        config.setParseLoginInvalidCredentialsToastText(text);
        return this;
    }

    /**
     * Customize the toast shown when the user enters an invalid username/password
     * pair.
     *
     * @param id
     *     The resource ID for the text to display on the toast.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseLoginInvalidCredentialsToastText(int id) {
        return setParseLoginInvalidCredentialsToastText(maybeGetString(id));
    }

    /**
     * Use the user's email as their username. By default, the user's username is
     * separate from their email; we ask the user for their username and email on
     * the signup form, and ask for their username on the login form. If this
     * option is set to true, we'll not ask for their username on the signup and
     * login forms; users will just enter their email on both (internally we'll
     * send the user email as the username when calling the Parse SDK).
     *
     * @param emailAsUsername
     *     Whether to use email as the user's username in the Parse SDK.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseLoginEmailAsUsername(boolean emailAsUsername) {
        config.setParseLoginEmailAsUsername(emailAsUsername);
        return this;
    }

    /**
     * Sets the minimum required password length on the user signup page.
     *
     * @param minPasswordLength
     *     The minimum required password length for signups
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseSignupMinPasswordLength(int minPasswordLength) {
        config.setParseSignupMinPasswordLength(minPasswordLength);
        return this;
    }

    /**
     * Customize the submit button on the Parse signup screen. This signup screen
     * is only shown if you enable Parse username/password login.
     *
     * @param text
     *     The text to display on the user signup submission button.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseSignupSubmitButtonText(CharSequence text) {
        config.setParseSignupSubmitButtonText(text);
        return this;
    }

    /**
     * Customize the submit button on the Parse signup screen. This signup screen
     * is only shown if you enable Parse username/password login.
     *
     * @param id
     *     The resource ID fo the text to display on the user signup
     *     submission button.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseSignupSubmitButtonText(int id) {
        return setParseSignupSubmitButtonText(maybeGetString(id));
    }

    /**
     * Whether to show the name field in the signup form. Default is true.
     *
     * @param enabled
     *     Whether to show the name field in the signup form.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setParseSignupNameFieldEnabled(boolean enabled) {
        config.setParseSignupNameFieldEnabled(enabled);
        return this;
    }

    /**
     * Whether to show the Facebook login option on the login screen. Default is
     * false.
     *
     * @param enabled
     *     Whether to show the facebook login.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setFacebookLoginEnabled(boolean enabled) {
        config.setFacebookLoginEnabled(enabled);
        return this;
    }

    /**
     * Customize the text on the Facebook login button.
     *
     * @param text
     *     The text to display on the Facebook login button.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setFacebookLoginButtonText(CharSequence text) {
        config.setFacebookLoginButtonText(text);
        return this;
    }

    /**
     * Customize the text on the Facebook login button.
     *
     * @param id
     *     The resource ID for the text to display on the Facebook login
     *     button.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setFacebookLoginButtonText(int id) {
        config.setFacebookLoginButtonText(maybeGetString(id));
        return this;
    }

    /**
     * Customize the requested permissions for Facebook login
     *
     * @param permissions
     *     The Facebook permissions being requested.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setFacebookLoginPermissions(
            Collection<String> permissions) {
        config.setFacebookLoginPermissions(permissions);
        return this;
    }

    /**
     * Whether to show the Twitter login option on the login screen. Default is
     * false.
     *
     * @param enabled
     *     Whether to show the Twitter login.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setTwitterLoginEnabled(boolean enabled) {
        config.setTwitterLoginEnabled(enabled);
        return this;
    }

    /**
     * Customize the text on the Twitter login button.
     *
     * @param loginButtonText
     *     The text to display on the Twitter login button.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setTwitterLoginButtontext(
            CharSequence loginButtonText) {
        config.setTwitterLoginButtonText(loginButtonText);
        return this;
    }

    /**
     * Customize the text on the Twitter login button.
     *
     * @param id
     *     The text to display on the Twitter login button.
     * @return The caller instance to allow chaining.
     */
    public ArabChatSignupBuilder setTwitterLoginButtontext(int id) {
        config.setTwitterLoginButtonText(maybeGetString(id));
        return this;
    }

    /**
     * Construct an intent that can be used to start ArabChatSignupActivity with the
     * specified customizations.
     *
     * @return The intent for starting ArabChatSignupActivity
     */
    public Intent build() {
        Intent intent = new Intent(context, ArabChatSignupActivity.class);
        intent.putExtras(config.toBundle());
        return intent;
    }

    private String maybeGetString(int id) {
        return id != 0 ? context.getString(id) : null;
    }
}

