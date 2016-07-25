package com.study.EmbeddedJettySpringExample.service;

import com.study.EmbeddedJettySpringExample.model.FooInfo;

public interface IFooInfoService {

	public FooInfo createFooInfo(FooInfo fooInfo);
	public FooInfo updateFooInfo(FooInfo fooInfo);
}
