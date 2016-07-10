package com.study.EmbeddedJettySpringExample.service;

import java.util.Collection;

import com.study.EmbeddedJettySpringExample.model.UnitOBDDetailMid;


public interface IUnitOBDDetailMidService {
	
	public Collection<UnitOBDDetailMid> getAllDataByCityId(String cityId);
	
	public void updateByCityId(UnitOBDDetailMid data);
	
	public void getException() throws IllegalArgumentException;
	
	public void getAround();
}
