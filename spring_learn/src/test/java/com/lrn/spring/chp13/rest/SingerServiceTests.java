package com.lrn.spring.chp13.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.gen5.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lrn.spring.rmt.rest.config.fortests.DataConfig;
import com.lrn.spring.rmt.rest.config.fortests.DataSets;
import com.lrn.spring.rmt.rest.config.fortests.ServiceConfig;
import com.lrn.spring.rmt.rest.config.fortests.ServiceTestConfig;
import com.lrn.spring.rmt.rest.model.Singer;
import com.lrn.spring.rmt.rest.service.SingerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceConfig.class, ServiceTestConfig.class, DataConfig.class })
@TestExecutionListeners({ ServiceTestExecutionListener.class })
@ActiveProfiles("test")
public class SingerServiceTests extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	SingerService singerService;

	@PersistenceContext
	EntityManager em;

	@Test
	@DataSets(setUpDataSet = "<location to dataset>")
	public void testFindAll() {
		List<Singer> singers = singerService.findAll();

		assertNotNull(singers);
		assertEquals(1, singers.size());
	}

/*	@DataSets(setUpDataSet = "/com/apress/prospring5/ch13/SingerServiceImplTest.xls")
	@Test
	public void testFindByFirstNameAndLastName_1() throws Exception {
		Singer result = singerService.findByFirstNameAndLastName("John", "Mayer");
		assertNotNull(result);
	}

	@DataSets(setUpDataSet = "/com/apress/prospring5/ch13/SingerServiceImplTest.xls")
	@Test
	public void testFindByFirstNameAndLastName_2() throws Exception {
		Singer result = singerService.findByFirstNameAndLastName("BB", "King");
		assertNull(result);
	}*/
}
