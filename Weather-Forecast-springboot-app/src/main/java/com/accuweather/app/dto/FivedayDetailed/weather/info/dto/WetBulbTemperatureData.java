package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WetBulbTemperatureData {
	@JsonProperty("Minimum")
	private ValueUnitType minimum;
	
	@JsonProperty("Maximum")
	private ValueUnitType maximum;
	
	@JsonProperty("Average")
	private ValueUnitType average;
}
