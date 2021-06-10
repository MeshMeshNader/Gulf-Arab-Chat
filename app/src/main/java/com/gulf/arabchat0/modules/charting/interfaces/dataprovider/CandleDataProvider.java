package com.gulf.arabchat0.modules.charting.interfaces.dataprovider;

import com.gulf.arabchat0.modules.charting.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
