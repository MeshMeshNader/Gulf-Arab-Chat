package com.gulf.arabchat.modules.cardstackview.internal;

import android.view.animation.Interpolator;

import com.gulf.arabchat.modules.cardstackview.Direction;


public interface AnimationSetting {
    Direction getDirection();
    int getDuration();
    Interpolator getInterpolator();
}
