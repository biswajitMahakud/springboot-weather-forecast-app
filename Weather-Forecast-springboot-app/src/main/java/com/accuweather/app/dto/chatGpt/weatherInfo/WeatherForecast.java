package com.accuweather.app.dto.chatGpt.weatherInfo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
    public static class Headline {
    	@JsonProperty("EffectiveDate")
        private String effectiveDate;
    	@JsonProperty("EffectiveEpochDate")
        private long effectiveEpochDate;
    	@JsonProperty("Severity")
        private int severity;
    	@JsonProperty("Text")
        private String text;
    	@JsonProperty("Category")
        private String category;
    	@JsonProperty("EndDate")
        private String endDate;
    	@JsonProperty("EndEpochDate")
        private long endEpochDate;
    	@JsonProperty("MobileLink")
        private String mobileLink;
    	@JsonProperty("Link")
        private String link;

        // Add getters and setters here

        // You may also want to override toString() for debugging purposes
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Temperature {
    	@Data
    	@NoArgsConstructor
    	@AllArgsConstructor
        public static class TemperatureValue {
        	@JsonProperty("Value")
            private double value;
        	@JsonProperty("Unit")
            private String unit;
        	@JsonProperty("UnitType")
            private int unitType;

            // Add getters and setters here
        }
        @JsonProperty("Minimum")
        private TemperatureValue minimum;
        @JsonProperty("Maximum")
        private TemperatureValue maximum;

        // Add getters and setters here
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DayNight {
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

        // Add getters and setters here
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DailyForecast {
    	@JsonProperty("Date")
        private String date;
    	@JsonProperty("EpochDate")
        private long epochDate;
    	@JsonProperty("Temperature")
        private Temperature temperature;
    	@JsonProperty("Day")
        private DayNight day;
    	@JsonProperty("Night")
        private DayNight night;
    	@JsonProperty("Sources")
        private List<String> sources;
    	@JsonProperty("MobileLink")
        private String mobileLink;
    	@JsonProperty("Link")
        private String link;

        // Add getters and setters here
    }
    @JsonProperty("Headline")
    private Headline headline;
    @JsonProperty("DailyForecasts")
    private List<DailyForecast> dailyForecasts;

    // Add getters and setters here
}

