package com.lrn.spring.javaConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
	private String message;
//	= "Default message";

	public ConfigurableMessageProvider() {
	}

	public ConfigurableMessageProvider(@Value("Love The Weeknd") String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
