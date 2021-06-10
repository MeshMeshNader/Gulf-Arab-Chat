package com.gulf.arabchat0.modules.instagram;

import com.gulf.arabchat0.models.others.InstagramUser;

public interface AuthCallback {
  void onSuccess(InstagramUser socialUser);

  void onError(Throwable error);

  void onCancel();
}
