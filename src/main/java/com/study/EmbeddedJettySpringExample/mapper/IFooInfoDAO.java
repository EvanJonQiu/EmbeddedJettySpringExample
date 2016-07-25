package com.study.EmbeddedJettySpringExample.mapper;

import com.study.EmbeddedJettySpringExample.model.FooInfo;

public interface IFooInfoDAO {

	public void createFooInfo(FooInfo fooInfo);
	public void updateFooInfo(FooInfo fooInfo);
}
