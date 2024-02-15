package com.accuweather.app.dto.weatherInfo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfo {
	@JsonProperty("Headline")
	private Headline headLine;
	@JsonProperty("DailyForecasts")
	private List<DailyForecast> dailyForecasts;
	
}
