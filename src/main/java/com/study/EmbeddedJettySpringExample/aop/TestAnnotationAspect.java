package com.study.EmbeddedJettySpringExample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAnnotationAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(TestAnnotationAspect.class);

	@Before("execution(* com.study.EmbeddedJettySpringExample.service.IUnitOBDDetailMidService.getAllDataByCityId(..))")
	public void doBefore(JoinPoint joinPoint) {
		logger.debug("TestAnnotationAspect.doBefore " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.study.EmbeddedJettySpringExample.service.IUnitOBDDetailMidService.getAllDataByCityId(..))")
	public void doAfter(JoinPoint joinPoint) {
		logger.debug("TestAnnotationAspect.doAfter " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
	}
	
	@AfterReturning(
			pointcut="execution(* com.study.EmbeddedJettySpringExample.service.IUnitOBDDetailMidService.getAllDataByCityId(..))",
			returning="result")
	public void doAfterReturning(JoinPoint joinPoint, Object result) {
		logger.debug("TestAnnotationAspect.doAfterReturning " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(
			pointcut="execution(* com.study.EmbeddedJettySpringExample.service.IUnitOBDDetailMidService.getException(..))",
			throwing="error"
			)
	public void doAfterThrowing(JoinPoint joinPoint, Throwable error) {
		logger.debug("TestAnnotationAspect.doAfterThrowing " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
	}
	
	@Around("execution(* com.study.EmbeddedJettySpringExample.service.IUnitOBDDetailMidService.getAround(..))")
	public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.debug("TestAnnotationAspect.doAround " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
		logger.debug("TestAnnotationAspect.doAround.before");
		joinPoint.proceed();
		logger.debug("TestAnnotationAspect.doAround.after");
	}
}
