package com.lrn.spring.aop.advice.checkKey;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceDemo {
	public static void main(String[] args) {
		KeyGenerator key = getKeyGen();
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(key.getKey());
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}
		}
	}

	static KeyGenerator getKeyGen() {
		KeyGenerator target = new KeyGenerator();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new WeakKeyCheckAdvice());
		pf.setTarget(target);

		return (KeyGenerator) pf.getProxy();
	}

}
