package com.lrn.spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

	public static void main(String[] args) {
		Guitarist jimiHndrxx = new Guitarist();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleBeforeAdvice());
		pf.setTarget(jimiHndrxx);

		Guitarist gProxy = (Guitarist) pf.getProxy();

		gProxy.sing();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Before " + method.getName() + " tune with Guitar...hehe");
	}

}
