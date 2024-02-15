package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiveDayTemperatureInfo {
	@JsonProperty("Minimum")
	private MinMaxTempDetails minimum;
	@JsonProperty("Maximum")
	private MinMaxTempDetails maximum;
}
