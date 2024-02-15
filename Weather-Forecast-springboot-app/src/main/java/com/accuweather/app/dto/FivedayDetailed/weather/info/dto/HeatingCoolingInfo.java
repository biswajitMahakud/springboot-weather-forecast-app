package com.accuweather.app.dto.FivedayDetailed.weather.info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeatingCoolingInfo {
	@JsonProperty("Heating")
	private ValueUnitType heating;
	@JsonProperty("Cooling")
	private ValueUnitType Cooling;
}
