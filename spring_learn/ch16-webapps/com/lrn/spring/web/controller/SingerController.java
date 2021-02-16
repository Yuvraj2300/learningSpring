package com.lrn.spring.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lrn.spring.web.entities.Singer;
import com.lrn.spring.web.service.SingerService;

@RequestMapping("/singers")
@Controller
public class SingerController {
	private final Logger logger = LoggerFactory.getLogger(SingerController.class);

	private SingerService singerService;
	// private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		logger.info("Listing singers");
		List<Singer> singers = singerService.findAll();
		model.addAttribute("singers", singers);
		return "/singers/list";
	}

	@Autowired
	public SingerController(SingerService singerService) {
		super();
		this.singerService = singerService;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model uiModel) {
		Singer singer = singerService.findById(id);
		uiModel.addAttribute("singer", singer);

		return "singers/show";
	}

}
