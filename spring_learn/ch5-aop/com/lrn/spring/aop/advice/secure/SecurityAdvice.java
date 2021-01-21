package com.lrn.spring.aop.advice.secure;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {

	SecurityManager secMan;

	public SecurityAdvice() {
		secMan = new SecurityManager();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		UserInfo user = secMan.getLoggedOnUser();

		if (user == null) {
			throw new SecurityException("You must be logged on to use " + method.getName());
		} else if (user.getName().equals("John")) {
			System.out.println("John has the access");
		} else {
			System.out.println("Logged in user is " + user.getName() + " who is not authorized");
			throw new SecurityException(
					user.getName() + " does not have proper auth on this method " + method.getName());
		}
	}
}
