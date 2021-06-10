package com.gulf.arabchat0.modules.dotsindicator;

import android.content.Context;
import android.util.TypedValue;

import com.gulf.arabchat0.R;


public class UiUtils {
  public static int getThemePrimaryColor(final Context context) {
    final TypedValue value = new TypedValue();
    context.getTheme().resolveAttribute(R.attr.colorPrimary, value, true);
    return value.data;
  }
}
