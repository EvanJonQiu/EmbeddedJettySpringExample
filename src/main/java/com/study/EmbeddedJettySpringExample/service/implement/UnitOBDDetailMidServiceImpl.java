package com.study.EmbeddedJettySpringExample.service.implement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.study.EmbeddedJettySpringExample.mapper.IUnitOBDDetailMidDAO;
import com.study.EmbeddedJettySpringExample.model.UnitOBDDetailMid;
import com.study.EmbeddedJettySpringExample.service.IUnitOBDDetailMidService;

@Service
public class UnitOBDDetailMidServiceImpl implements IUnitOBDDetailMidService {
	
	@Autowired
	private IUnitOBDDetailMidDAO unitOBDDetailMidDAO;

	@Cacheable(value="baseCache")
	public Collection<UnitOBDDetailMid> getAllDataByCityId(String cityId) {
		return unitOBDDetailMidDAO.getAllDataByCityId(cityId);
	}
	
	@CacheEvict(value="baseCache", allEntries=true)
	public void updateByCityId(UnitOBDDetailMid data) {
		unitOBDDetailMidDAO.updateByCityId(data);
	}

}
