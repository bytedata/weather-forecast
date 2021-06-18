package com.bytedata.weatherforecast.service;

import java.net.URI;
import java.net.URL;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.bytedata.weatherforecast.WeatherProperties;
import com.bytedata.weatherforecast.model.Weather;
@Service
public class WeatherService {
	private final RestTemplate restTemplate;
	private final String apiKey;

	public static final String WEATHER_URL_1 = "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}&units=metric";
	
	public static final String WEATHER_URL_2 = "http://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&APPID={key}&units=metric";

	public WeatherService(RestTemplateBuilder restTemplateBuilder, WeatherProperties properties) {
		this.restTemplate = restTemplateBuilder.build();
		this.apiKey = properties.getApi().getKey();
		
	}
	@Cacheable("weather")
	public Weather getWeather1(String country, String city ) {
		URI url= new UriTemplate(WEATHER_URL_1).expand(city,country,this.apiKey);
		return invoke(url,Weather.class);
	}
	@Cacheable("geo")
	public Weather getWeather2(String lat, String lon ) {
		URI url= new UriTemplate(WEATHER_URL_2).expand(lat,lon,this.apiKey);
		return invoke(url,Weather.class);
	}

	private <T> T invoke(URI url, Class<T> responseType) {
		RequestEntity<?> requestEntity = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<T> exchange = this.restTemplate.exchange(requestEntity, responseType);
		return exchange.getBody();

	}

}
