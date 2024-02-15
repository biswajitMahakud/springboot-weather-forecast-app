package com.accuweather.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
	@JsonProperty("Version")
    private int Version;
	@JsonProperty("Key")
    private String Key;
	@JsonProperty("Type")
    private String Type;
	@JsonProperty("Rank")
    private int Rank;
	@JsonProperty("LocalizedName")
    private String LocalizedName;
	@JsonProperty("EnglishName")
    private String EnglishName;
	@JsonProperty("PrimaryPostalCode")
    private String PrimaryPostalCode;
	@JsonProperty("Region")
    private RegionInfo Region;
	@JsonProperty("Country")
    private CountryInfo Country;
	@JsonProperty("AdministrativeArea")
    private AdministrativeAreaInfo AdministrativeArea;
	@JsonProperty("TimeZone")
    private TimeZoneInfo TimeZone;
	@JsonProperty("GeoPosition")
    private GeoPositionInfo GeoPosition;
	@JsonProperty("IsAlias")
    private boolean IsAlias;
    @JsonProperty("SupplementalAdminAreas")
    private List<SupplementalAdminAreaInfo> SupplementalAdminAreas;
    @JsonProperty("DataSets")
    private List<String> DataSets;

    // Getters and setters
}
