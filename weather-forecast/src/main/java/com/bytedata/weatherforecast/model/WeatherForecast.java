package com.bytedata.weatherforecast.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherForecast implements Serializable{
	private String city;
	List<WeatherDetails> entries = new ArrayList<>();
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@JsonProperty("entries")
	public List<WeatherDetails> getEntries() {
		return entries;
	}
	@JsonProperty("list")
	public void setEntries(List<WeatherDetails> entries) {
		this.entries = entries;
	}
	@JsonProperty("city")
	public void setCity(Map<String, Object> city) {
		setCity(city.get("city").toString());
	}
	
	
	
	
}
