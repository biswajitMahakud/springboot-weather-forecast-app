package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendingResponseObject {
	String headlineText;
	String headlineCategory;
	String dailyForecastSunrise ;
	String dailyForecastSunset;
	String dailyForecastMoonrise ;
	String dailyForecastMoonset ;
	double minTemp;
	double maxTemp;
	double realFeelMinTemp;
	String realFeelMinTempPhrase;
	double realFeelMaxTemp;
	String realFeelMaxTempPhrase;
	String airPolutionName;
	String airPolutionCategory;
	
	//day data
	String dayIconPhrase;
	boolean dayPrecipitation;
	String dayShortPhrase ;
	String dayLongPhrase;
	int dayPrecipitationProbability;
	int dayThunderstormProbability;
	int dayRainProbability;
	int daySnowProbability;
	int dayIceProbability;
	double dayWindSpeed;
	String dayWindSpeedUnit;
	String dayWindSpeedDirection;
	long dayWindSpeedDegree;

	double dayWindGustSpeed;
	String dayWindGustSpeedUnit;
	String dayWindGustSpeedDirection;
	long dayWindGustSpeedDegree ;

	double dayRainValue;
	String dayRainUnit;

	double daySnowValue;
	String daySnowUnit;

	double dayIceValue;
	String dayIceUnit;

	double dayHoursOfPrecipitation;
	double dayHoursOfRain;
	double dayHoursOfSnow;
	double dayHoursOfIce;
	long dayCloudCover;

	double dayEvapotranspirationValue;
	String dayEvapotranspirationUnit;

	double daySolarIrradianceValue ;
	String daySolarIrradianceUnit;

	long dayRelativeHumbidityMinimum;
	long dayRelativeHumbidityMaximum;
	long dayRelativeHumbidityAvg;

	double dayWetBulbTemperatureMinValue;
	String dayWetBulbTemperatureMinValueUnit;

	double dayWetBulbTemperatureMaxValue;
	String dayWetBulbTemperatureMaxValueUnit;

	double dayWetBulbTemperatureAvgValue;
	String dayWetBulbTemperatureAvgValueUnit;
	
	
	//night data
	
	String nightIconPhrase;
	boolean nightPrecipitation;
	String nightShortPhrase ;
	String nightLongPhrase;
	int nightPrecipitationProbability;
	int nightThunderstormProbability;
	int nightRainProbability;
	int nightSnowProbability;
	int nightIceProbability;
	double nightWindSpeed;
	String nightWindSpeedUnit;
	String nightWindSpeedDirection;
	long nightWindSpeedDegree;

	double nightWindGustSpeed;
	String nightWindGustSpeedUnit;
	String nightWindGustSpeedDirection;
	long nightWindGustSpeedDegree ;

	double nightRainValue;
	String nightRainUnit;

	double nightSnowValue;
	String nightSnowUnit;

	double nightIceValue;
	String nightIceUnit;

	double nightHoursOfPrecipitation;
	double nightHoursOfRain;
	double nightHoursOfSnow;
	double nightHoursOfIce;
	long nightCloudCover;

	double nightEvapotranspirationValue;
	String nightEvapotranspirationUnit;

	double nightSolarIrradianceValue ;
	String nightSolarIrradianceUnit;

	long nightRelativeHumbidityMinimum;
	long nightRelativeHumbidityMaximum;
	long nightRelativeHumbidityAvg;

	double nightWetBulbTemperatureMinValue;
	String nightWetBulbTemperatureMinValueUnit;

	double nightWetBulbTemperatureMaxValue;
	String nightWetBulbTemperatureMaxValueUnit;

	double nightWetBulbTemperatureAvgValue;
	String nightWetBulbTemperatureAvgValueUnit;
}
