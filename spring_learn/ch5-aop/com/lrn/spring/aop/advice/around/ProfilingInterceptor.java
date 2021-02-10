package com.lrn.spring.aop.advice.around;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class ProfilingInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(invocation.getMethod().getName());
		Object returnValue = invocation.proceed();
		sw.stop();
		dumpInfo(invocation, sw.getLastTaskTimeMillis());
		return returnValue;
	}

	private void dumpInfo(MethodInvocation invocation, long lastTaskTimeMillis) {
		// TODO Auto-generated method stub
		Method m = invocation.getMethod();
		Object target = invocation.getThis();
		Object[] args = invocation.getArguments();

		System.out.println("Executed method: " + m.getName());
		System.out.println("On object of type: " + target.getClass().getName());
		System.out.println("With arguments:");
		for (int x = 0; x < args.length; x++) {
			System.out.print(" > " + args);
		}
		System.out.print("\n");
		System.out.println("Took: " + lastTaskTimeMillis + " ms");
	}

}
