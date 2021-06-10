package com.gulf.arabchat0.modules.charting.interfaces.dataprovider;

import com.gulf.arabchat0.modules.charting.data.BubbleData;

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
