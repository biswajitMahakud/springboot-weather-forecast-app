package com.accuweather.app.dto.weatherInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfoResponse {
	
	private String text;
	private String currDate;
	private double minTemp;
	private double maxTemp;
	private String dayIconPhrase;
	private boolean dayHasPrecipitation;
	private String dayPrecipitationType;
	private String nightIconPhrase;
	private boolean nightHasPrecipitation;
	private String nightPrecipitationType;
	
	
}
