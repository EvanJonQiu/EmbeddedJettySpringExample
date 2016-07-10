package com.study.EmbeddedJettySpringExample.service.implement;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.study.EmbeddedJettySpringExample.mapper.IUnitOBDDetailMidDAO;
import com.study.EmbeddedJettySpringExample.model.UnitOBDDetailMid;
import com.study.EmbeddedJettySpringExample.service.IUnitOBDDetailMidService;

@Service
public class UnitOBDDetailMidServiceImpl implements IUnitOBDDetailMidService {
	
	private static final Logger logger = LoggerFactory.getLogger(UnitOBDDetailMidServiceImpl.class);
	
	@Autowired
	private IUnitOBDDetailMidDAO unitOBDDetailMidDAO;

	@Cacheable(value="baseCache")
	public Collection<UnitOBDDetailMid> getAllDataByCityId(String cityId) {
		logger.debug("UnitOBDDetailMidServiceImpl.getAllDataByCityId");
		return unitOBDDetailMidDAO.getAllDataByCityId(cityId);
	}
	
	@CacheEvict(value="baseCache", allEntries=true)
	public void updateByCityId(UnitOBDDetailMid data) {
		logger.debug("UnitOBDDetailMidServiceImpl.updateByCityId");
		unitOBDDetailMidDAO.updateByCityId(data);
	}
	
	public void getException() throws IllegalArgumentException {
		logger.debug("UnitOBDDetailMidServiceImpl.getException");
		throw new IllegalArgumentException("An exception");
	}

	public void getAround() {
		logger.debug("UnitOBDDetailMidServiceImpl.getAround");
	}
}
