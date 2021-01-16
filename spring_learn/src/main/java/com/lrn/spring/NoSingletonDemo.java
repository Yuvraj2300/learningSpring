package com.lrn.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lrn.spring.annotation.Singer;

public class NoSingletonDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

		ctx.load("classpath:app-context-annotation.xml");
		ctx.refresh();

		Singer singer1 = ctx.getBean("nonSingleton", Singer.class);
		Singer singer2 = ctx.getBean("nonSingleton", Singer.class);
		System.out.println("Identity Equal?: " + (singer1 == singer2));
		System.out.println("Value Equal:? " + singer1.equals(singer2));
		System.out.println(singer1);
		System.out.println(singer2);

		ctx.close();
	}
}
