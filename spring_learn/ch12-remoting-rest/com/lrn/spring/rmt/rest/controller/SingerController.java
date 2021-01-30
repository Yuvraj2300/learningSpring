package com.lrn.spring.rmt.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lrn.spring.rmt.rest.model.Singer;
import com.lrn.spring.rmt.rest.model.Singers;
import com.lrn.spring.rmt.rest.service.SingerService;

@Controller
@RequestMapping("/singer")
public class SingerController {
	final Logger logger = LoggerFactory.getLogger(SingerController.class);

	@Autowired
	SingerService singerService;

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value = "/listData", method = RequestMethod.GET)
	public Singers listData() {
		return new Singers(singerService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Singer findSingerById(@PathVariable Long id) {
		return singerService.findById(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Singer create(@RequestBody Singer singer) {
		logger.info("Creating singer: " + singer);
		singerService.save(singer);
		logger.info("Singer created successfully with info: " + singer);
		return singer;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@RequestBody Singer singer, @PathVariable Long id) {
		logger.info("Updating singer: " + singer);
		singerService.save(singer);
		logger.info("Singer updated successfully with info: " + singer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		logger.info("Deleting singer with id: " + id);
		Singer singer = singerService.findById(id);
		singerService.delete(singer);
		logger.info("Singer deleted successfully");
	}
}
