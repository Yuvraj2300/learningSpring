package com.lrn.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.jpa.entities.Album;
import com.lrn.spring.jpa.service.AlbumService;
import com.lrn.spring.jpa.config.AppConfig;

public class AlbumJpaTest {
	private static Logger logger = LoggerFactory.getLogger(AlbumJpaTest.class);

	private GenericApplicationContext ctx;
	private AlbumService albumService;

	@Before
	public void setUp() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//ctx.refresh();
		albumService = (AlbumService) ctx.getBean("springJpaAlbumService");
		assertNotNull(albumService);
	}

	@Test
	public void testFindByTitle() {
		List<Album> albums = albumService.findByTitle("The");
		assertTrue(albums.size() > 0);
		assertEquals(2, albums.size());
		albums.forEach(a -> logger
				.info(a.toString() + ", Singer: " + a.getSinger().getFirstName() + " " + a.getSinger().getLastName()));
	}

	@After
	public void tearDown() {
		ctx.close();
	}

}
