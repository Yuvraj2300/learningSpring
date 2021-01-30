package com.lrn.spring.chp13.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import com.lrn.spring.rmt.rest.controller.SingerController;
import com.lrn.spring.rmt.rest.model.Singer;
import com.lrn.spring.rmt.rest.model.Singers;
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
		SingerService singerService = mock(SingerService.class);
		when(singerService.findAll()).thenReturn(singers);

		SingerController cont = new SingerController();

		ReflectionTestUtils.setField(cont, "singerService", singerService);
		
		ExtendedModelMap uiModel = new ExtendedModelMap();
		uiModel.addAttribute("singers", cont.listData());

		Singers modelSingers = (Singers) uiModel.get("singers");
		assertEquals(1, modelSingers.getSingers().size());
	}

}
