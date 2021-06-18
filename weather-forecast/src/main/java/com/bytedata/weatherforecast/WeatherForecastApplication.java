package com.bytedata.weatherforecast;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@EnableConfigurationProperties(WeatherProperties.class)
@EnableCaching(proxyTargetClass = true)
public class WeatherForecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastApplication.class, args);
	}

	
	
	/*
	 * @Bean public Docket swaggerConfig() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .paths(PathSelectors.ant("/weather/*"))
	 * .apis(RequestHandlerSelectors.basePackage(
	 * "com.bytedata.weatherforecast.controller")) .build() .apiInfo(apiDetails());
	 * }
	 * 
	 * private ApiInfo apiDetails() { return new ApiInfo("Weather forecast",
	 * "API Documentation", "1.0", "API License", "@krishna", "contact",
	 * "copy right"); }
	 */
}	 
