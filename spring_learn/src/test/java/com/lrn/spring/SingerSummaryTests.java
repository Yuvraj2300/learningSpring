package com.lrn.spring;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.jpa.config.AppConfig;
import com.lrn.spring.jpa.service.SingerSummaryUntypeImpl;

public class SingerSummaryTests {
	private static Logger logger = LoggerFactory.getLogger(SingerSummaryTests.class);
	private GenericApplicationContext ctx;
	private SingerSummaryUntypeImpl singerSummaryUntype;

	@Before
	public void setUp() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		singerSummaryUntype = ctx.getBean(SingerSummaryUntypeImpl.class);
		assertNotNull(singerSummaryUntype);
	}

	@Test
	public void testFindAllUntype() {
		singerSummaryUntype.displaySummary();
	}

	@After
	public void tearDown() {
		ctx.close();
	}
}
