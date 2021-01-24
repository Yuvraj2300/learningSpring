package com.lrn.spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleAfterMethodAdvice implements AfterReturningAdvice {

	public static void main(String[] args) {
		Guitarist target = new Guitarist();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleAfterMethodAdvice());
		pf.setTarget(target);

		Guitarist proxy = (Guitarist) pf.getProxy();
		proxy.sing();
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("#### After : " + method.getName() + "() put down guitar champ!");
	}

}
