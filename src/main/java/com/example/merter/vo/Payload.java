
package com.example.merter.vo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Payload {

    @SerializedName("connectorId")
    @Expose
    private Integer connectorId;
    @SerializedName("transactionId")
    @Expose
    private Integer transactionId;
    @SerializedName("meterValue")
    @Expose
    private List<MeterValue> meterValue;

    public Integer getConnectorId() {
        return connectorId;
    }

    public void setConnectorId(Integer connectorId) {
        this.connectorId = connectorId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public List<MeterValue> getMeterValue() {
        return meterValue;
    }

    public void setMeterValue(List<MeterValue> meterValue) {
        this.meterValue = meterValue;
    }

}
