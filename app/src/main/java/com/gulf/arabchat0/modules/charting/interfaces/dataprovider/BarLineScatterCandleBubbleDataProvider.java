package com.gulf.arabchat0.modules.charting.interfaces.dataprovider;

import com.gulf.arabchat0.modules.charting.components.YAxis.AxisDependency;
import com.gulf.arabchat0.modules.charting.data.BarLineScatterCandleBubbleData;
import com.gulf.arabchat0.modules.charting.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);
    boolean isInverted(AxisDependency axis);
    
    float getLowestVisibleX();
    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
