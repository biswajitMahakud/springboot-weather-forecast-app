package com.accuweather.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accuweather.app.dto.CityDto;
import com.accuweather.app.dto.Location;
import com.accuweather.app.dto.FivedayDetailed.weather.info.dto.DailyForecast;
import com.accuweather.app.dto.FivedayDetailed.weather.info.dto.FiveDayWeatherInfo;
import com.accuweather.app.dto.FivedayDetailed.weather.info.dto.SendingResponseObject;
import com.accuweather.app.dto.chatGpt.weatherInfo.WeatherForecast;
import com.accuweather.app.dto.weatherInfo.Headline;
import com.accuweather.app.dto.weatherInfo.WeatherInfo;
import com.accuweather.app.dto.weatherInfo.WeatherInfoResponse;
@Service
public class WeatherForecastService {
	String apiKey = "R657hnNGScKZD7czsNl48iDGCpYsLNlO";
	// get Weather info by using Location Key .......... Accuweather API
	public WeatherInfoResponse getWeatherData(CityDto cityDetails) {
		System.out.println(cityDetails);
		// ResponseEntity<List<Location>> response =
		// getLocationInfoByCity(cityDetails.getCity());
		String locationKey = getLocationKeyByCity(cityDetails.getCity());
		System.out.println("Inside getweatherData.............");
		String weatherDataUrl = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/" + locationKey
				+ "?apikey="+apiKey;
		System.out.println("Weather url: " + weatherDataUrl);
		RestTemplate template = new RestTemplate();
		// The below commented code, inside exchange method weatherForecast class is
		// used to deserialize json to java classes
		/*
		 * ResponseEntity<WeatherForecast> secondweatherInfo =
		 * template.exchange(weatherDataUrl, HttpMethod.GET, null,
		 * WeatherForecast.class);
		 */
		// But, this is my way... weatherInfo.class is created by me...
		ResponseEntity<WeatherInfo> weatherInfo = template.exchange(weatherDataUrl, HttpMethod.GET, null,
				WeatherInfo.class);

		System.out.println("Weather information(By using my way): Day Data"
				+ weatherInfo.getBody().getDailyForecasts().get(0).getDay());
		System.out.println("Weather information(By using my way): Night Data"
				+ weatherInfo.getBody().getDailyForecasts().get(0).getNight());
		System.out.println("Creating Json Objects...");
		// creating appropriate java pojo class itself when it's return to the frontend
		// layer it converted to json object

		String text = weatherInfo.getBody().getHeadLine().getText();
		String date = weatherInfo.getBody().getDailyForecasts().get(0).getDate();
		double minTemp = weatherInfo.getBody().getDailyForecasts().get(0).getTemperature().getMinimum().getValue();
		double maxTemp = weatherInfo.getBody().getDailyForecasts().get(0).getTemperature().getMaximum().getValue();
		String dayIconPhrase = weatherInfo.getBody().getDailyForecasts().get(0).getDay().getIconPhrase();
		boolean dayHasPrecipitation = weatherInfo.getBody().getDailyForecasts().get(0).getDay().isHasPrecipitation();
		String dayPrecipitationType = weatherInfo.getBody().getDailyForecasts().get(0).getDay().getPrecipitationType();
		String nightIconPhrase = weatherInfo.getBody().getDailyForecasts().get(0).getNight().getIconPhrase();
		boolean nightHasPrecipitation = weatherInfo.getBody().getDailyForecasts().get(0).getNight()
				.isHasPrecipitation();
		String nightPrecipitationType = weatherInfo.getBody().getDailyForecasts().get(0).getNight()
				.getPrecipitationType();

		WeatherInfoResponse responsebody = new WeatherInfoResponse(text, date, minTemp, maxTemp, dayIconPhrase,
				dayHasPrecipitation, dayPrecipitationType, nightIconPhrase, nightHasPrecipitation,
				nightPrecipitationType);

		return responsebody;
	}

	// get location info by using city name.......... Accuweather API
	public ResponseEntity<List<Location>> getLocationInfoByCity(String cityName) {
		String url = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey="+apiKey
				+ "&q=" + cityName;
		System.out.println(url);
		System.out.println("Inside getLocationInfoByCity:---------");
		RestTemplate template = new RestTemplate();
		ResponseEntity<List<Location>> response = template.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Location>>() {
				});
		System.out.println(response);
		System.out.println("Inside getLocationInfoByCity:After calling exchange function----");
		// System.out.println(response.getBody());
		return response;
	}
	
	

	// get 5day of weather details...

	public List<SendingResponseObject> GetFiveDyWeatherData(CityDto cityDetails) {
		String locationKey = getLocationKeyByCity(cityDetails.getCity());
		System.out.println("Inside GetFiveDyWeatherData() method........");

		String url = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + locationKey
				+ "?apikey="+apiKey+"&details=true";
		System.out.println("Inside GetFiveDyWeatherData and url is: " + url);
		RestTemplate template = new RestTemplate();
		ResponseEntity<FiveDayWeatherInfo> response = template.exchange(url, HttpMethod.GET, null,
				FiveDayWeatherInfo.class);

		System.out.println("Five Day daily weather forecast Data: " + response.getBody());
		System.out.println("-------------------------------------------------");

		String headlineText = response.getBody().getHeadLine().getText();
		String headlineCategory = response.getBody().getHeadLine().getCategory();

		List<DailyForecast> dailyForecastList = response.getBody().getDailyForecasts();
		List<SendingResponseObject> responseObj = new ArrayList<SendingResponseObject>();

		for (DailyForecast weatherData : dailyForecastList) {
			System.out.println("Inside WeatherForecastService : Iterating Over the DailyForecast Object...");
			String dailyForecastSunrise = weatherData.getSun().getRise();
			String dailyForecastSunset = weatherData.getSun().getSet();
			String dailyForecastMoonrise = weatherData.getMoon().getRise();
			String dailyForecastMoonset = weatherData.getMoon().getSet();
			double minTemp = weatherData.getTemperature().getMinimum().getValue();
			double maxTemp = weatherData.getTemperature().getMaximum().getValue();
			double realFeelMinTemp = weatherData.getRealFeelTemperature().getMinimum().getValue();
			String realFeelMinTempPhrase = weatherData.getRealFeelTemperature().getMinimum().getPhrase();
			double realFeelMaxTemp = weatherData.getRealFeelTemperature().getMaximum().getValue();
			String realFeelMaxTempPhrase = weatherData.getRealFeelTemperature().getMaximum().getPhrase();
			String airPolutionName = weatherData.getAirAndPollen().get(0).getName();
			String airPolutionCategory = weatherData.getAirAndPollen().get(0).getCategory();

			// iterate over day object....
			String dayIconPhrase = weatherData.getDay().getIconPhrase();
			boolean dayPrecipitation = weatherData.getDay().isHasPrecipitation();
			String dayShortPhrase = weatherData.getDay().getShortPhrase();
			String dayLongPhrase = weatherData.getDay().getLongPhrase();
			int dayPrecipitationProbability = weatherData.getDay().getPrecipitationProbability();
			int dayThunderstormProbability = weatherData.getDay().getThunderstormProbability();
			int dayRainProbability = weatherData.getDay().getRainProbability();
			int daySnowProbability = weatherData.getDay().getSnowProbability();
			int dayIceProbability = weatherData.getDay().getIceProbability();
			double dayWindSpeed = weatherData.getDay().getWind().getSpeed().getValue();
			String dayWindSpeedUnit = weatherData.getDay().getWind().getSpeed().getUnit();
			String dayWindSpeedDirection = weatherData.getDay().getWind().getDirection().getLocalized();
			long dayWindSpeedDegree = weatherData.getDay().getWind().getDirection().getDegrees();

			double dayWindGustSpeed = weatherData.getDay().getWindGust().getSpeed().getValue();
			String dayWindGustSpeedUnit = weatherData.getDay().getWindGust().getSpeed().getUnit();
			String dayWindGustSpeedDirection = weatherData.getDay().getWindGust().getDirection().getLocalized();
			long dayWindGustSpeedDegree = weatherData.getDay().getWindGust().getDirection().getDegrees();

			double dayRainValue = weatherData.getDay().getRain().getValue();
			String dayRainUnit = weatherData.getDay().getRain().getUnit();

			double daySnowValue = weatherData.getDay().getSnow().getValue();
			String daySnowUnit = weatherData.getDay().getSnow().getUnit();

			double dayIceValue = weatherData.getDay().getIce().getValue();
			String dayIceUnit = weatherData.getDay().getIce().getUnit();

			double dayHoursOfPrecipitation = weatherData.getDay().getHoursOfPrecipitation();
			double dayHoursOfRain = weatherData.getDay().getHoursOfRain();
			double dayHoursOfSnow = weatherData.getDay().getHoursOfSnow();
			double dayHoursOfIce = weatherData.getDay().getHoursOfIce();
			long dayCloudCover = weatherData.getDay().getCloudCover();

			double dayEvapotranspirationValue = weatherData.getDay().getEvapotranspiration().getValue();
			String dayEvapotranspirationUnit = weatherData.getDay().getEvapotranspiration().getUnit();

			double daySolarIrradianceValue = weatherData.getDay().getSolarIrradiance().getValue();
			String daySolarIrradianceUnit = weatherData.getDay().getSolarIrradiance().getUnit();

			long dayRelativeHumbidityMinimum = weatherData.getDay().getRelativeHumidity().getMinimum();
			long dayRelativeHumbidityMaximum = weatherData.getDay().getRelativeHumidity().getMaximum();
			long dayRelativeHumbidityAvg = weatherData.getDay().getRelativeHumidity().getAverage();

			double dayWetBulbTemperatureMinValue = weatherData.getDay().getWetBulbTemperature().getMinimum().getValue();
			String dayWetBulbTemperatureMinValueUnit = weatherData.getDay().getWetBulbTemperature().getMinimum()
					.getUnit();

			double dayWetBulbTemperatureMaxValue = weatherData.getDay().getWetBulbTemperature().getMaximum().getValue();
			String dayWetBulbTemperatureMaxValueUnit = weatherData.getDay().getWetBulbTemperature().getMaximum()
					.getUnit();

			double dayWetBulbTemperatureAvgValue = weatherData.getDay().getWetBulbTemperature().getAverage().getValue();
			String dayWetBulbTemperatureAvgValueUnit = weatherData.getDay().getWetBulbTemperature().getAverage()
					.getUnit();

			// iterate over Night object...
			String nightIconPhrase = weatherData.getNight().getIconPhrase();
			boolean nightPrecipitation = weatherData.getNight().isHasPrecipitation();
			String nightShortPhrase = weatherData.getNight().getShortPhrase();
			String nightLongPhrase = weatherData.getNight().getLongPhrase();
			int nightPrecipitationProbability = weatherData.getNight().getPrecipitationProbability();
			int nightThunderstormProbability = weatherData.getNight().getThunderstormProbability();
			int nightRainProbability = weatherData.getNight().getRainProbability();
			int nightSnowProbability = weatherData.getNight().getSnowProbability();
			int nightIceProbability = weatherData.getNight().getIceProbability();
			double nightWindSpeed = weatherData.getNight().getWind().getSpeed().getValue();
			String nightWindSpeedUnit = weatherData.getNight().getWind().getSpeed().getUnit();
			String nightWindSpeedDirection = weatherData.getNight().getWind().getDirection().getLocalized();
			long nightWindSpeedDegree = weatherData.getNight().getWind().getDirection().getDegrees();

			double nightWindGustSpeed = weatherData.getNight().getWindGust().getSpeed().getValue();
			String nightWindGustSpeedUnit = weatherData.getNight().getWindGust().getSpeed().getUnit();
			String nightWindGustSpeedDirection = weatherData.getNight().getWindGust().getDirection().getLocalized();
			long nightWindGustSpeedDegree = weatherData.getNight().getWindGust().getDirection().getDegrees();

			double nightRainValue = weatherData.getNight().getRain().getValue();
			String nightRainUnit = weatherData.getNight().getRain().getUnit();

			double nightSnowValue = weatherData.getNight().getSnow().getValue();
			String nightSnowUnit = weatherData.getNight().getSnow().getUnit();

			double nightIceValue = weatherData.getNight().getIce().getValue();
			String nightIceUnit = weatherData.getNight().getIce().getUnit();

			double nightHoursOfPrecipitation = weatherData.getNight().getHoursOfPrecipitation();
			double nightHoursOfRain = weatherData.getNight().getHoursOfRain();
			double nightHoursOfSnow = weatherData.getNight().getHoursOfSnow();
			double nightHoursOfIce = weatherData.getNight().getHoursOfIce();
			long nightCloudCover = weatherData.getNight().getCloudCover();

			double nightEvapotranspirationValue = weatherData.getNight().getEvapotranspiration().getValue();
			String nightEvapotranspirationUnit = weatherData.getNight().getEvapotranspiration().getUnit();

			double nightSolarIrradianceValue = weatherData.getNight().getSolarIrradiance().getValue();
			String nightSolarIrradianceUnit = weatherData.getNight().getSolarIrradiance().getUnit();

			long nightRelativeHumbidityMinimum = weatherData.getNight().getRelativeHumidity().getMinimum();
			long nightRelativeHumbidityMaximum = weatherData.getNight().getRelativeHumidity().getMaximum();
			long nightRelativeHumbidityAvg = weatherData.getNight().getRelativeHumidity().getAverage();

			double nightWetBulbTemperatureMinValue = weatherData.getNight().getWetBulbTemperature().getMinimum().getValue();
			String nightWetBulbTemperatureMinValueUnit = weatherData.getNight().getWetBulbTemperature().getMinimum()
					.getUnit();

			double nightWetBulbTemperatureMaxValue = weatherData.getNight().getWetBulbTemperature().getMaximum().getValue();
			String nightWetBulbTemperatureMaxValueUnit = weatherData.getNight().getWetBulbTemperature().getMaximum()
					.getUnit();

			double nightWetBulbTemperatureAvgValue = weatherData.getNight().getWetBulbTemperature().getAverage().getValue();
			String nightWetBulbTemperatureAvgValueUnit = weatherData.getNight().getWetBulbTemperature().getAverage()
					.getUnit();
			
			SendingResponseObject respObj = new SendingResponseObject(headlineText, headlineCategory, dailyForecastSunrise, dailyForecastSunset, dailyForecastMoonrise, dailyForecastMoonset, minTemp, maxTemp, realFeelMinTemp, realFeelMinTempPhrase, realFeelMaxTemp, realFeelMaxTempPhrase, airPolutionName, airPolutionCategory, dayIconPhrase, dayPrecipitation, dayShortPhrase, dayLongPhrase, dayPrecipitationProbability, dayThunderstormProbability, dayRainProbability, daySnowProbability, dayIceProbability, dayWindSpeed, dayWindSpeedUnit, dayWindSpeedDirection, dayWindSpeedDegree, dayWindGustSpeed, dayWindGustSpeedUnit, dayWindGustSpeedDirection, dayWindGustSpeedDegree, dayRainValue, dayRainUnit, daySnowValue, daySnowUnit, dayIceValue, dayIceUnit, dayHoursOfPrecipitation, dayHoursOfRain, dayHoursOfSnow, dayHoursOfIce, dayCloudCover, dayEvapotranspirationValue, dayEvapotranspirationUnit, daySolarIrradianceValue, daySolarIrradianceUnit, dayRelativeHumbidityMinimum, dayRelativeHumbidityMaximum, dayRelativeHumbidityAvg, dayWetBulbTemperatureMinValue, dayWetBulbTemperatureMinValueUnit, dayWetBulbTemperatureMaxValue, dayWetBulbTemperatureMaxValueUnit, dayWetBulbTemperatureAvgValue, dayWetBulbTemperatureAvgValueUnit, nightIconPhrase, nightPrecipitation, nightShortPhrase, nightLongPhrase, nightPrecipitationProbability, nightThunderstormProbability, nightRainProbability, nightSnowProbability, nightIceProbability, nightWindSpeed, nightWindSpeedUnit, nightWindSpeedDirection, nightWindSpeedDegree, nightWindGustSpeed, nightWindGustSpeedUnit, nightWindGustSpeedDirection, nightWindGustSpeedDegree, nightRainValue, nightRainUnit, nightSnowValue, nightSnowUnit, nightIceValue, nightIceUnit, nightHoursOfPrecipitation, nightHoursOfRain, nightHoursOfSnow, nightHoursOfIce, nightCloudCover, nightEvapotranspirationValue, nightEvapotranspirationUnit, nightSolarIrradianceValue, nightSolarIrradianceUnit, nightRelativeHumbidityMinimum, nightRelativeHumbidityMaximum, nightRelativeHumbidityAvg, nightWetBulbTemperatureMinValue, nightWetBulbTemperatureMinValueUnit, nightWetBulbTemperatureMaxValue, nightWetBulbTemperatureMaxValueUnit, nightWetBulbTemperatureAvgValue, nightWetBulbTemperatureAvgValueUnit);
			
			responseObj.add(respObj);
		}

		return responseObj;
	}

	
	
	// Find out the location key of the city using cityName.........Accuweather API
	public String getLocationKeyByCity(String cityName) {
		String key = null;
		String url = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey="+apiKey
				+ "&q=" + cityName;
		System.out.println("Location Key: " + url);
		System.out.println("Inside getLocationKeyByCity:---------");
		RestTemplate template = new RestTemplate();

		ResponseEntity<List<Location>> response = template.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Location>>() {
				});
	     key = response.getBody().get(0).getKey();
		System.out.println("Key of the city: " + key);


		return key;
	}

}
