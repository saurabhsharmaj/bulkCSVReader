
package com.example.merter.vo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.opencsv.bean.CsvDate;


public class MeterValue {

    @SerializedName("timestamp")
    @Expose
    @CsvDate(value = "yyyy-MM-dd")
    private String timestamp;
    @SerializedName("sampledValue")
    @Expose
    private List<SampledValue> sampledValue;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<SampledValue> getSampledValue() {
        return sampledValue;
    }

    public void setSampledValue(List<SampledValue> sampledValue) {
        this.sampledValue = sampledValue;
    }

}
