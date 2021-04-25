package com.gulf.arabchat.modules.charting.interfaces.dataprovider;

import com.gulf.arabchat.modules.charting.components.YAxis;
import com.gulf.arabchat.modules.charting.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
