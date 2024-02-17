
package com.example.merter.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SampledValue {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("context")
    @Expose
    private String context;
    @SerializedName("measurand")
    @Expose
    private String measurand;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("phase")
    @Expose
    private String phase;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getMeasurand() {
        return measurand;
    }

    public void setMeasurand(String measurand) {
        this.measurand = measurand;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

}
