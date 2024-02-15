package com.accuweather.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricInfo {
	@JsonProperty("Value")
    private double Value;
	@JsonProperty("Unit")
    private String Unit;
	@JsonProperty("UnitType")
    private int UnitType;

    // Getters and setters
}
