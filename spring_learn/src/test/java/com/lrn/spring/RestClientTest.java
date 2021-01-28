package com.lrn.spring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.lrn.spring.rmt.rest.config.RestClientConfig;
import com.lrn.spring.rmt.rest.model.Singers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RestClientConfig.class })
public class RestClientTest {
	final Logger logger = LoggerFactory.getLogger(RestClientTest.class);
	private static final String URL_GET_ALL_SINGERS = "http://localhost:8080/singer/listdata";
	private static final String URL_GET_SINGER_BY_ID = "http://localhost:8080/singer/{id}";
	private static final String URL_CREATE_SINGER = "http://localhost:8080/singer/";
	private static final String URL_UPDATE_SINGER = "http://localhost:8080/singer/{id}";
	private static final String URL_DELETE_SINGER = "http://localhost:8080/singer/{id}";

	@Autowired
	RestTemplate restTemplate;

	@Before
	public void setUp() {
		assertNotNull(restTemplate);
	}

	@Test
	public void testFindAll() {
		Singers singers = restTemplate.getForObject(URL_GET_ALL_SINGERS, Singers.class);
		assertTrue(singers.getSingers().size() == 3);
	}

	@Test
	public void testUpdate() {
		logger.info("--> Testing update singer by id : 1");
		Singer singer = restTemplate.getForObject(URL_UPDATE_SINGER, Singer.class, 1);
		singer.setName("John Clayton");
		restTemplate.put(URL_UPDATE_SINGER, singer, 1);
		logger.info("Singer update successfully: " + singer);
	}

	@Test
	public void testDelete() {
		logger.info("--> Testing delete singer by id : 3");
		restTemplate.delete(URL_DELETE_SINGER, 3);
		Singers singers = restTemplate.getForObject(URL_GET_ALL_SINGERS, Singers.class);
		Boolean found = false;
		for (com.lrn.spring.rmt.rest.model.Singer s : singers.getSingers()) {
			if (s.getId() == 3) {
				found = true;
			}
		}
		;
		assertFalse(found);
		listSingers(singers);
	}

	private void listSingers(Singers singers) {
		singers.getSingers().forEach(s -> logger.info(s.toString()));
	}
}
