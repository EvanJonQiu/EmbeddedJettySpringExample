package com.study.EmbeddedJettySpringExample.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.EmbeddedJettySpringExample.model.UnitOBDDetailMid;
import com.study.EmbeddedJettySpringExample.service.IUnitOBDDetailMidService;

@Controller
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private IUnitOBDDetailMidService unitOBDDetailMidService;
	
	@RequestMapping(value = "/testResult", method = RequestMethod.GET)
	@ResponseBody
	public String testResult() {
		return "Hello World";
	}
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	@ResponseBody
	public Collection<UnitOBDDetailMid> getAllDataByCityId() {
		return unitOBDDetailMidService.getAllDataByCityId("419");
	}
	
	/**
	 * Update a record
	 * @param data
	 * @return the updated data
	 */
	@RequestMapping(value = "/updateData")
	@ResponseBody
	public UnitOBDDetailMid updateByCityId(UnitOBDDetailMid data) {
		unitOBDDetailMidService.updateByCityId(data);
		return data;
	}
}
