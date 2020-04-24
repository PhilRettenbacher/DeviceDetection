package com.devicedetection.model;

import java.util.List;

public class FullConsumptionData
{
    public String[] values;
    public List<ConsumptionPointTime> data;
    public FullConsumptionData(List<ConsumptionPointTime> data, String[] values)
    {
        this.values = values;
        this.data = data;
    }
}