package com.gulf.arabchat.modules.instagram;

import com.gulf.arabchat.models.others.InstagramUser;

public interface AuthCallback {
  void onSuccess(InstagramUser socialUser);

  void onError(Throwable error);

  void onCancel();
}
