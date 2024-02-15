package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiveDayWeatherInfo {
	@JsonProperty("Headline")
	private FiveDayForecastHeadline headLine;
	@JsonProperty("DailyForecasts")
	private List<DailyForecast> dailyForecasts;
	
}
