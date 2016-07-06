package com.study.EmbeddedJettySpringExample.mapper;

import java.util.Collection;

import com.study.EmbeddedJettySpringExample.model.UnitOBDDetailMid;


public interface IUnitOBDDetailMidDAO {

	public Collection<UnitOBDDetailMid> getAllDataByCityId(String cityId);
	
	public void updateByCityId(UnitOBDDetailMid data);
}
