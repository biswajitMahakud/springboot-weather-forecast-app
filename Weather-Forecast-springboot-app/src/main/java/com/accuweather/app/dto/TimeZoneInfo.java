package com.accuweather.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeZoneInfo {
	@JsonProperty("Code")
    private String Code;
	@JsonProperty("Name")
    private String Name;
	@JsonProperty("GmtOffset")
    private double GmtOffset;
	@JsonProperty("IsDaylightSaving")
    private boolean IsDaylightSaving;
	@JsonProperty("NextOffsetChange")
    private Object NextOffsetChange; // You might want to create a class for this if needed

    // Getters and setters
}
