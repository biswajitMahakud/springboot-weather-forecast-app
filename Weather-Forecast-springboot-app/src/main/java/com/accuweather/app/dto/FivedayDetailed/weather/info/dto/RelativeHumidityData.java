package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelativeHumidityData {
	@JsonProperty("Minimum")
	private long minimum;
	@JsonProperty("Maximum")
	private long maximum;
	@JsonProperty("Average")
	private long average;
}
