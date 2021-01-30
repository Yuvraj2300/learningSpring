package com.lrn.spring.chp13.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lrn.spring.rmt.rest.model.Singer;
import com.lrn.spring.rmt.rest.service.SingerService;;

public class SingerControllerTest {

	private final List<Singer> singers = new ArrayList<>();

	@Before
	private void initSingers() {
		Singer singer = new Singer();
		singer.setId(1l);
		singer.setFirstName("John");
		singer.setLastName("Mayer");
		singers.add(singer);
	}

	@Test
	public void testList() throws Exception {
		SingerService singerService;
	}

}
