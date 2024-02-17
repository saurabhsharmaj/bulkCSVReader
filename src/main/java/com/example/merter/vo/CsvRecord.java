package com.example.merter.vo;

import com.opencsv.bean.CsvBindByName;

public class CsvRecord {

	@CsvBindByName(column = "charge_point_id")
	private String chargePointId;
	
	@CsvBindByName(column = "payload")
	private String payload;

	public String getChargePointId() {
		return chargePointId;
	}

	public void setChargePointId(String chargePointId) {
		this.chargePointId = chargePointId;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	

}
