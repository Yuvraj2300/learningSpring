package com.lrn.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InhertanceDemp {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();

		Singer parent = (Singer) ctx.getBean("parent");
		Singer child = (Singer) ctx.getBean("child");
		System.out.println("Parent:\n" + parent);
		System.out.println("Child:\n" + child);
	}
}
