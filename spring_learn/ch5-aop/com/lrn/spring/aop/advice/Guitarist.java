package com.lrn.spring.aop.advice;

public class Guitarist implements Singer {
	private String lyric = "You only live once, YOLO";

	@Override
	public void sing() {
		System.out.println(lyric);
	}

}
