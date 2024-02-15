package com.accuweather.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentCity {
	@JsonProperty("Key")
    private String Key;
	@JsonProperty("LocalizedName")
    private String LocalizedName;
	@JsonProperty("EnglishName")
    private String EnglishName;
}
