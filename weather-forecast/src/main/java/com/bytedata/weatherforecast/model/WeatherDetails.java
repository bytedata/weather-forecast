package com.bytedata.weatherforecast.model;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherDetails {
	private Integer weatherId;
	private double temperature;
	private String lat;
	private String lon;
	private Instant timestamp;

	public Integer getWeatherId() {
		return weatherId;
	}

	public void setWeatherId(Integer weatherId) {
		this.weatherId = weatherId;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		setTemperature(Double.parseDouble(main.get("temp").toString()));
	}

	/*
	 * public String getLat() { return lat; }
	 * 
	 * public void setLat(String lat) { this.lat = lat; }
	 * 
	 * public String getLon() { return lon; }
	 * 
	 * public void setLon(String lon) { this.lon = lon; }
	 */
	@JsonProperty("timestamp")
	public Instant getTimestamp() {
		return timestamp;
	}

	@JsonSetter("dt")
	public void setTimestamp(Long unixTime) {
		this.timestamp = Instant.ofEpochMilli(unixTime * 1000);
	}

	@JsonProperty("weather")
	public void setWeather1(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherId((Integer) weather.get("id"));
		/*
		 * setLat((double) weather.get("lat")); setLon((double) weather.get("lon"));
		 */
	}

	@JsonProperty("geo")
	public void setWeather2(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherId((Integer) weather.get("id"));

		/*
		 * setLat((String) weather.get("lat")); setLon((String) weather.get("lon"));
		 */
	}
}
