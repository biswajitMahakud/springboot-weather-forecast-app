package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

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
	@JsonProperty("Sun")
	private SunAndMoonData sun;
	@JsonProperty("Moon")
	private SunAndMoonData moon;
	@JsonProperty("Temperature")
	private FiveDayTemperatureInfo temperature;
	
	@JsonProperty("RealFeelTemperature")
	private FiveDayTemperatureInfo realFeelTemperature;
	
	@JsonProperty("RealFeelTemperatureShade")
	private FiveDayTemperatureInfo realFeelTemperatureShade;
	
	@JsonProperty("HoursOfSun")
	private double hoursOfSun;
	
	@JsonProperty("DegreeDaySummary")
	private HeatingCoolingInfo degreeDaySummary;
	
	@JsonProperty("AirAndPollen")
	private List<AirAndPollenData> airAndPollen;
	
	@JsonProperty("Day")
	private DayNightData day;
	
	@JsonProperty("Night")
	private DayNightData night;
	
	@JsonProperty("Sources")
	private List<String> sources;
	
	@JsonProperty("MobileLink")
	private String mobileLink;
	
	
	@JsonProperty("Link")
	private String link;
}
