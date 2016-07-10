package com.study.EmbeddedJettySpringExample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OtherAspect {
	private static final Logger logger = LoggerFactory.getLogger(OtherAspect.class);
	
	@Before("execution(* com.study.EmbeddedJettySpringExample.service.IUnitOBDDetailMidService.getAllDataByCityId(..))")
	public void doBefore(JoinPoint joinPoint) {
		logger.debug("OtherAspect.doBefore " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
	}
}
