package com.lrn.spring.tx.working;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.tx.config.DataJpaConfig;
import com.lrn.spring.tx.config.ServicesConfig;
import com.lrn.spring.tx.entities.Album;
import com.lrn.spring.tx.entities.Singer;
import com.lrn.spring.tx.service.SingerService;

public class Demo {
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ServicesConfig.class,
				DataJpaConfig.class);
		SingerService singerService = ctx.getBean(SingerService.class);
		List<Singer> singers = singerService.findAll();
		Singer singer	=	singerService.findById(1L);
		singers.forEach(s -> {
			System.out.println(s);
		});
		System.out.println(singer.toString());
		
		/*Singer drake = new Singer();
		drake.setFirstName("Aubrey");
		drake.setLastName("Graham");
		
		System.out.println("Singer saved successfully: " + drake);*/
		ctx.close();
	}
}
