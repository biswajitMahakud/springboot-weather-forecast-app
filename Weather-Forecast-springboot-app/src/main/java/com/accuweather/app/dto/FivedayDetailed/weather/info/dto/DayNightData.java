package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayNightData {
	@JsonProperty("Icon")
	private int icon;
	
	@JsonProperty("IconPhrase")
	private String iconPhrase;
	
	@JsonProperty("HasPrecipitation")
	private boolean hasPrecipitation;
	
	@JsonProperty("ShortPhrase")
	private String ShortPhrase;
	
	@JsonProperty("LongPhrase")
	private String longPhrase;
	
	@JsonProperty("PrecipitationProbability")
	private int precipitationProbability;
	
	@JsonProperty("ThunderstormProbability")
	private int thunderstormProbability;
	
	@JsonProperty("RainProbability")
	private int rainProbability;
	
	@JsonProperty("SnowProbability")
	private int snowProbability;
	
	@JsonProperty("IceProbability")
	private int iceProbability;
	
	@JsonProperty("Wind")
	private WindData wind;
	
	@JsonProperty("WindGust")
	private WindData windGust;
	
	@JsonProperty("TotalLiquid")
	private ValueUnitType totalLiquid;
	
	@JsonProperty("Rain")
	private ValueUnitType rain;
	
	@JsonProperty("Snow")
	private ValueUnitType snow;

	@JsonProperty("Ice")
	private ValueUnitType ice;
	
	@JsonProperty("HoursOfPrecipitation")
	private double hoursOfPrecipitation;
	
	@JsonProperty("HoursOfRain")
	private double hoursOfRain;
	
	@JsonProperty("HoursOfSnow")
	private double hoursOfSnow;
	
	@JsonProperty("HoursOfIce")
	private double hoursOfIce;

	@JsonProperty("CloudCover")
	private long cloudCover;
	
	@JsonProperty("Evapotranspiration")
	private ValueUnitType evapotranspiration;
	
	@JsonProperty("SolarIrradiance")
	private ValueUnitType solarIrradiance;
	
	@JsonProperty("RelativeHumidity")
	private RelativeHumidityData relativeHumidity;
	
	@JsonProperty("WetBulbTemperature")
	private WetBulbTemperatureData wetBulbTemperature;
	
	@JsonProperty("WetBulbGlobeTemperature")
	private WetBulbTemperatureData wetBulbGlobeTemperature;
	
	
	
}
