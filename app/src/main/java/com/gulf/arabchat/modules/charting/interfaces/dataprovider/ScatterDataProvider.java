package com.gulf.arabchat.modules.charting.interfaces.dataprovider;

import com.gulf.arabchat.modules.charting.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
