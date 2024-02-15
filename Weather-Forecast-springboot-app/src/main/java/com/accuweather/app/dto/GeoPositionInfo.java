package com.accuweather.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoPositionInfo {
	@JsonProperty("Latitude")
    private double Latitude;
	@JsonProperty("Longitude")
    private double Longitude;
	@JsonProperty("Elevation")
    private ElevationInfo Elevation;
    // Getters and setters
}
