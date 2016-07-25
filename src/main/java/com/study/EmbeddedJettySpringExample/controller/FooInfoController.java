package com.study.EmbeddedJettySpringExample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.EmbeddedJettySpringExample.model.FooInfo;
import com.study.EmbeddedJettySpringExample.service.IFooInfoService;

@Controller
public class FooInfoController {

	private static final Logger logger = LoggerFactory.getLogger(FooInfoController.class);
	
	@Autowired
	private IFooInfoService fooInfoService;
	
	@RequestMapping(value="/createFooInfo")
	@ResponseBody
	public FooInfo createFooInfo(FooInfo fooInfo) {
		logger.debug("FooInfoController.createFooInfo");
		FooInfo result = fooInfoService.createFooInfo(fooInfo);
		return result;
	}
	
	@RequestMapping(value="/updateFooInfo")
	@ResponseBody
	public FooInfo updateFooInfo(FooInfo fooInfo) {
		logger.debug("FooInfoController.updateFooInfo");
		FooInfo result = fooInfoService.updateFooInfo(fooInfo);
		return result;
	}
}
