package com.lrn.spring.tx.working;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.tx.config.DataJpaConfig;
import com.lrn.spring.tx.config.ServicesConfig;
import com.lrn.spring.tx.entities.Singer;
import com.lrn.spring.tx.service.SingerService;

public class Demo {
	private static Logger logger = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args) {

		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ServicesConfig.class,
				DataJpaConfig.class);

		SingerService singerService = ctx.getBean(SingerService.class);
		List<Singer> singers = singerService.findAll();
		Singer singer = singerService.findById(1L);
		singers.forEach(s -> {
			System.out.println(s);
		});
		System.out.println(singer.toString());
		System.out.println("---------------------------Number of Singers---------------------------");
		System.out.println(singerService.countSingers());
		System.out.println("---------------------------Number of Singers---------------------------");
		/*
		 * Singer drake = new Singer(); drake.setFirstName("Aubrey");
		 * drake.setLastName("Graham");
		 * 
		 * System.out.println("Singer saved successfully: " + drake);
		 */
		ctx.close();
	}
}
