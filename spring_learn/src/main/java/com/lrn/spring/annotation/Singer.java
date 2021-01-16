package com.lrn.spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer")
@Scope("prototype")
public class Singer {
	private String name = "unknown";

	public Singer(@Value("johnMayer") String name) {
		super();
		this.name = name;
	}

}
