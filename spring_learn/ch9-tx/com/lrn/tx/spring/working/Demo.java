package com.lrn.tx.spring.working;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.tx.config.DataJpaConfig;
import com.lrn.spring.tx.config.ServicesConfig;
import com.lrn.tx.spring.entities.Singer;
import com.lrn.tx.spring.service.SingerService;

public class Demo {
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ServicesConfig.class,
				DataJpaConfig.class);
		SingerService singerService = (SingerService) ctx.getBean("singerService");
		List<Singer> singers = singerService.findAll();
		singers.forEach(s -> {
			System.out.println(s);
		});
		ctx.close();
	}
}
