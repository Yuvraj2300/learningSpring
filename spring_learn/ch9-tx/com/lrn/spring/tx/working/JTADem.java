package com.lrn.spring.tx.working;

import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.tx.entities.Singer;
import com.lrn.spring.tx.global.config.XAJPAConfig;
import com.lrn.spring.tx.service.SingerService;

public class JTADem {
	private static Logger logger = LoggerFactory.getLogger(JTADem.class);

	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(
				com.lrn.spring.tx.global.config.ServicesConfig.class, XAJPAConfig.class);
		SingerService singerService = ctx.getBean(SingerService.class);
		Singer singer = new Singer();
		singer.setFirstName("Kumar");
		singer.setLastName("Sanu");
		singer.setBirthDate(new Date((new GregorianCalendar(1977, 9, 16)).getTime().getTime()));
		singerService.save(singer);
		if (singer.getId() != null) {
			logger.info("--> Singer saved successfully");
		} else {
			logger.info("--> Singer was not saved, check the configuration!!");
		}
		ctx.close();
	}
}
