package com.gulf.arabchat.modules.charting.interfaces.dataprovider;

import com.gulf.arabchat.modules.charting.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
