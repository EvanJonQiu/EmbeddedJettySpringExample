package com.study.EmbeddedJettySpringExample.service.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.EmbeddedJettySpringExample.mapper.IFooInfoDAO;
import com.study.EmbeddedJettySpringExample.model.FooInfo;
import com.study.EmbeddedJettySpringExample.service.IFooInfoService;

@Service
public class FooInfoServiceImpl implements IFooInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(FooInfoServiceImpl.class);
	
	@Autowired
	private IFooInfoDAO fooInfoDao;

	public FooInfo createFooInfo(FooInfo fooInfo) {
		logger.debug("FooInfoServiceImpl.createFooInfo");
		fooInfoDao.createFooInfo(fooInfo);
		return fooInfo;
	}
	
	public FooInfo updateFooInfo(FooInfo fooInfo) {
		logger.debug("FooInfoServiceImpl.updateFooInfo");
		fooInfoDao.updateFooInfo(fooInfo);
		return fooInfo;
	}

}
