package com.accuweather.app.dto.weatherInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureInfo {
	@JsonProperty("Minimum")
	private MinimumVal minimum;
	@JsonProperty("Maximum")
	private MaximumVal maximum;
}
