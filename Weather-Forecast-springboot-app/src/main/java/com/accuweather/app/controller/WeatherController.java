package com.accuweather.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accuweather.app.dto.CityDto;
import com.accuweather.app.dto.Location;
import com.accuweather.app.dto.FivedayDetailed.weather.info.dto.FiveDayWeatherInfo;
import com.accuweather.app.dto.FivedayDetailed.weather.info.dto.SendingResponseObject;
import com.accuweather.app.dto.weatherInfo.WeatherInfoResponse;
import com.accuweather.app.service.WeatherForecastService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	WeatherForecastService service;
	
	@PostMapping("/get/forecast/data")
	public WeatherInfoResponse getWeatherData(@RequestBody CityDto cityDetails) {
		WeatherInfoResponse response = service.getWeatherData(cityDetails);
		return response;
	}
	

	//5day weather data get controller.... Testing
	@PostMapping(path="get/five/day/weather/data")
	public List<SendingResponseObject> GetFiveDayWeatherData(@RequestBody CityDto cityDetails) {
		List<SendingResponseObject> response = service.GetFiveDyWeatherData(cityDetails);
		return response;
	}
	
	@PostMapping("/get/city/details")
	public void getCityDetails(@RequestBody List<Location> cityDetails) {
		System.out.println(cityDetails);
		for(Location ele : cityDetails) {
			System.out.println(ele.getKey());
		}
	}
	
}
