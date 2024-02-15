package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirAndPollenData {
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Value")
	private int value;
	@JsonProperty("Category")
	private String category;
	@JsonProperty("CategoryValue")
	private int categoryValue;
	@JsonProperty("Type")
	private String type;
}
