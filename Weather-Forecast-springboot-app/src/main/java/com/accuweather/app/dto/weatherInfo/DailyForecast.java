package com.accuweather.app.dto.weatherInfo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyForecast {
	@JsonProperty("Date")
	private String date;
	@JsonProperty("EpochDate")
	private long epochDate;
	@JsonProperty("Temperature")
	private TemperatureInfo temperature;
	@JsonProperty("Day")
	private DayData day;
	@JsonProperty("Night")
	private NightData night;
	@JsonProperty("Sources")
	List<String> sources;
	@JsonProperty("MobileLink")
	private String mobileLink;
	@JsonProperty("Link")
	private String link;

}
