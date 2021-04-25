package com.gulf.arabchat.modules.dotsindicator;

import android.content.Context;
import android.util.TypedValue;

import com.gulf.arabchat.R;


public class UiUtils {
  public static int getThemePrimaryColor(final Context context) {
    final TypedValue value = new TypedValue();
    context.getTheme().resolveAttribute(R.attr.colorPrimary, value, true);
    return value.data;
  }
}
