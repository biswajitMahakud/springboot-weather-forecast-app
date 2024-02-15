package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectionData {
	@JsonProperty("Degrees")
	private long degrees;
	@JsonProperty("Localized")
	private String localized;
	@JsonProperty("English")
	private String english;
}
