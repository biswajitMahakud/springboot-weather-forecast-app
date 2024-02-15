package com.accuweather.app.dto.weatherInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinimumVal {
	@JsonProperty("Value")
	private double value;
	@JsonProperty("Unit")
	private String unit;
	@JsonProperty("UnitType")
	private int unitType;
}
