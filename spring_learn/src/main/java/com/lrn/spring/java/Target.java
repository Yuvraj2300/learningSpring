package com.lrn.spring.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.xml.Bar;
import com.lrn.spring.xml.Foo;
import com.lrn.spring.xml.FooImplOne;
import com.lrn.spring.xml.FooImplTwo;
import com.lrn.spring.xml.TrickyTarget;

public class Target {

	@Configuration
	static class TargetConfig {
		@Bean
		public Foo fooImplOne() {
			return new FooImplOne();
		}

		@Bean
		public Foo fooImplTwo() {
			return new FooImplTwo();
		}

		@Bean
		public Bar bar() {
			return new Bar();
		}

		@Bean
		public TrickyTarget trickyTarget() {
			return new TrickyTarget();
		}
	}

	public static void main(String... args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(TargetConfig.class);
		TrickyTarget t = ctx.getBean(TrickyTarget.class);
		ctx.close();
	}
}
