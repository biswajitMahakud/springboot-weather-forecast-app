package com.accuweather.app.dto.weatherInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayData {	
	@JsonProperty("Icon")
	private int icon;
	@JsonProperty("IconPhrase")
	private String iconPhrase;
	@JsonProperty("HasPrecipitation")
	private boolean hasPrecipitation;
	@JsonProperty("PrecipitationType")
	private String precipitationType;
	@JsonProperty("PrecipitationIntensity")
	private String precipitationIntensity;
}
