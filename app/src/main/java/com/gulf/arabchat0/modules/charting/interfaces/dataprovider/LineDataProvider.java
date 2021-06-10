package com.gulf.arabchat0.modules.charting.interfaces.dataprovider;

import com.gulf.arabchat0.modules.charting.components.YAxis;
import com.gulf.arabchat0.modules.charting.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
