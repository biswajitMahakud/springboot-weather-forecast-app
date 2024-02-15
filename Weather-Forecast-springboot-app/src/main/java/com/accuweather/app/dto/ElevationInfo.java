package com.accuweather.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElevationInfo {
	@JsonProperty("Metric")
    private MetricInfo Metric;
	@JsonProperty("Imperial")
    private ImperialInfo Imperial;

    // Getters and setters
}
