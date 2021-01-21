package com.lrn.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.jpa.config.AppConfig;
import com.lrn.spring.jpa.entities.Album;
import com.lrn.spring.jpa.entities.Instrument;
import com.lrn.spring.jpa.entities.Singer;
import com.lrn.spring.jpa.service.SingerService;

public class SingerJPATest {
	private static Logger logger = LoggerFactory.getLogger(SingerJPATest.class);
	private GenericApplicationContext ctx;
	private SingerService singerService;

	@Before
	public void setUp() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// ctx.refresh();
		String[] str = ctx.getBeanDefinitionNames();
		List<String> lst = Arrays.asList(str);
		lst.forEach(s -> {
			System.out.println(s);
		});
		singerService = (SingerService) ctx.getBean("jpaSingerService");
		assertNotNull(singerService);
	}

	/*
	 * @Test public void testFindAll() { List<Singer> singers =
	 * singerService.findAll(); assertEquals(3, singers.size());
	 * listSingers(singers); }
	 */
	private static void listSingers(List<Singer> singers) {
		logger.info(" ---- Listing singers:");
		for (Singer singer : singers) {
			logger.info(singer.toString());
		}
	}

	
	public void testFindAllWithAlbum() {
		List<Singer> singers = singerService.findAllWithAlbum();
		assertEquals(3, singers.size());
		listSingersWithAlbum(singers);
	}

	@Test
	public void testFindWithId() {
		Long id = 1L;
		Singer singerwithId = singerService.findById(id);
		assertNotNull(singerwithId);
		listSinger(singerwithId);
		// assertEquals(id, singerwithId.getId());
	}

	static void listSinger(Singer singer) {
		System.out.println(singer.toString());
	}

	@After
	public void tearDown() {
		ctx.close();
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
					logger.info("\tInstrument: " + instrument.getInstrumentId());
				}
			}
		}
	}
}
