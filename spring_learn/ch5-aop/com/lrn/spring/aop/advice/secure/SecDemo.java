package com.lrn.spring.aop.advice.secure;

import org.springframework.aop.framework.ProxyFactory;

public class SecDemo {
	public static void main(String[] args) {
		SecurityManager mgr = new SecurityManager();
		SecureBean bean = getSecureBean();

		mgr.login("John", "xyz");
		bean.writeSecureBean();
		mgr.logout();

		try {
			mgr.login("invalid user", "pwd");
			bean.writeSecureBean();
		} catch (SecurityException ex) {
			System.out.println("Exception Caught: " + ex.getMessage());
		} finally {
			mgr.logout();
		}

		try {
			bean.writeSecureBean();
		} catch (SecurityException ex) {
			System.out.println("Exception Caught: " + ex.getMessage());
		}
	}

	private static SecureBean getSecureBean() {

		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new SecureBean());
		factory.addAdvice(new SecurityAdvice());

		SecureBean proxybean = (SecureBean) factory.getProxy();

		return proxybean;
	}
}
