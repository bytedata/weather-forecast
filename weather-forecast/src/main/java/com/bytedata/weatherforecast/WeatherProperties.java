package com.bytedata.weatherforecast;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app.weather")
public class WeatherProperties {

	@Valid
	private final Api api = new Api();
	
	
	public Api getApi() {
		return this.api;
	}

	public static class Api {
		@NotNull
		private String key;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

	}
}
