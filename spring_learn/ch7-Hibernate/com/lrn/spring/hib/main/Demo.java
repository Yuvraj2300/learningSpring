package com.lrn.spring.hib.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.hib.config.AppConfig;
import com.lrn.spring.hib.dao.SingerDao;
import com.lrn.spring.hib.entities.Album;
import com.lrn.spring.hib.entities.Instrument;
import com.lrn.spring.hib.entities.Singer;

public class Demo {
	private static Logger logger = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args) {

		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		SingerDao singerDao = ctx.getBean(SingerDao.class);
		// singerDao.delete(singer);
		// listSingers(singerDao.findAll());
		listSingersWithAlbum(singerDao.findAllWithAlbum());
		Singer singer = singerDao.findById(2l);
		logger.info(singer.toString());
	}

	private static void listSingersWithAlbum(List<Singer> singers) {
		logger.info(" ---- Listing singers with instruments:");
		for (Singer singer : singers) {
			logger.info(singer.toString());
			if (singer.getAlbums() != null) {
				for (Album album : singer.getAlbums()) {
					logger.info("\t" + album.toString());
				}
			}
			if (singer.getInstruments() != null) {
				for (Instrument instrument : singer.getInstruments()) {
					logger.info("\t" + instrument.getInstrumentId());
				}
			}
		}
	}

	private static void listSingers(List<Singer> singers) {
		logger.info(" ---- Listing singers:");
		for (Singer singer : singers) {
			logger.info(singer.toString());
		}
	}
}
