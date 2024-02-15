package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiveDayForecastHeadline {
	@JsonProperty("EffectiveDate")
	private String effectiveDate;
	@JsonProperty("EffectiveEpochDate")
	private long effectiveEpochDate;
	@JsonProperty("Severity")
	private int severity;
	@JsonProperty("Text")
	private String text;
	@JsonProperty("Category")
	private String category;
	@JsonProperty("EndDate")
	private String endDate;
	@JsonProperty("EndEpochDate")
	private long endEpochDate;
	@JsonProperty("MobileLink")
	private String mobileLink;
	@JsonProperty("Link")
	private String link;
}
