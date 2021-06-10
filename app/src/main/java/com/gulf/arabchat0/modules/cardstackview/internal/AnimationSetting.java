package com.gulf.arabchat0.modules.cardstackview.internal;

import android.view.animation.Interpolator;

import com.gulf.arabchat0.modules.cardstackview.Direction;


public interface AnimationSetting {
    Direction getDirection();
    int getDuration();
    Interpolator getInterpolator();
}
