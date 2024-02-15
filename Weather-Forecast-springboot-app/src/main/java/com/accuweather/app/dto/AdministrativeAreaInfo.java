package com.accuweather.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministrativeAreaInfo {
	@JsonProperty("ID")
    private String ID;
	@JsonProperty("LocalizedName")
    private String LocalizedName;
	@JsonProperty("EnglishName")
    private String EnglishName;
	@JsonProperty("Level")
    private int Level;
	@JsonProperty("LocalizedType")
    private String LocalizedType;
	@JsonProperty("EnglishType")
    private String EnglishType;
	@JsonProperty("CountryID")
    private String CountryID;

    // Getters and setters
}
