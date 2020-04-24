package com.devicedetection.model;

import java.util.Date;

public class ConsumptionPointTime
{
    public int[] values;
    public Date time;
    public ConsumptionPointTime(int[] values, Date time)
    {
        this.values = values;
        this.time = time;
    }
}