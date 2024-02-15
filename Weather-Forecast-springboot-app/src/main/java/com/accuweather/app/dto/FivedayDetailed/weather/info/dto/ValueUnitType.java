package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValueUnitType {
	@JsonProperty("Value")
	private double value;
	@JsonProperty("Unit")
	private String unit;
	@JsonProperty("UnitType")
	private int unitType;
}
