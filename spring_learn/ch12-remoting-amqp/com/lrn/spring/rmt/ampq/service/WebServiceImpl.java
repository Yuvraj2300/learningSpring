package com.lrn.spring.rmt.ampq.service;

public class WebServiceImpl implements WeatherService {

	@Override
	public String getForecast(String stateCode) {
		if ("FL".equals(stateCode)) {
			return "Hot";
		} else if ("MA".equals(stateCode)) {
			return "Cold";
		}
		return "Not available at this time";
	}
}
