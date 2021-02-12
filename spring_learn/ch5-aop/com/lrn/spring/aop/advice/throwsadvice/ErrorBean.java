package com.lrn.spring.aop.advice.throwsadvice;

public class ErrorBean {
	public void errorProne() throws Exception {
		throw new Exception("Generic Exception");
	}

	public void otherErrorProneMethod() throws Exception {
		throw new IllegalArgumentException("Illegal Argument Exception");
	}
}
