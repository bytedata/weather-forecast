package com.bytedata.weatherforecast.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bytedata.weatherforecast.model.Weather;
import com.bytedata.weatherforecast.service.WeatherService;

@RestController
@RequestMapping(method = RequestMethod.GET, value="/weather")
public class WeatherController {

	private final WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@RequestMapping("/today/{country}/{city}")
	public Weather getWeather1(@PathVariable("country") String country, @PathVariable("city") String city) {
		return this.weatherService.getWeather1(country, city);

	}
	@RequestMapping("/geo/{lat}/{lon}")
	public Weather getWeather2(@PathVariable("lat") String lat, @PathVariable("lon") String lon) {
		return this.weatherService.getWeather2(lat, lon);
		
	}

}
