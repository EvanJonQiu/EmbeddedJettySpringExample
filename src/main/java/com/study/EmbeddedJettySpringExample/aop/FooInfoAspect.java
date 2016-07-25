package com.study.EmbeddedJettySpringExample.aop;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.study.EmbeddedJettySpringExample.model.FooInfo;

@Aspect
@Component
public class FooInfoAspect {

	private static final Logger logger = LoggerFactory.getLogger(FooInfoAspect.class);
	
	@Before("execution(public * com.study.EmbeddedJettySpringExample.service.IFooInfoService.createFooInfo(..)) && args(fooInfo,..)")
	public void createDoBefore(JoinPoint joinPoint, FooInfo fooInfo) {
		logger.debug("FooInfoAspect.doBefore " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
		
		String methodName = joinPoint.getSignature().getName();
		boolean createOption = false;
		if (methodName.startsWith("create")) {
			createOption = true;
		}
		if (createOption) {
			Object ao = joinPoint.getArgs()[0];
			if (ao != null) {
				setCreateOperationFieldData(ao, "admin");
			}
		}
	}
	
	@Before("execution(public * com.study.EmbeddedJettySpringExample.service.IFooInfoService.updateFooInfo(..)) && args(fooInfo,..)")
	public void updateDoBefore(JoinPoint joinPoint, FooInfo fooInfo) {
		logger.debug("FooInfoAspect.updateDoBefore " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
		
		String methodName = joinPoint.getSignature().getName();
		boolean updateOption = false;
		if (methodName.startsWith("update")) {
			updateOption = true;
		}
		if (updateOption) {
			Object ao = joinPoint.getArgs()[0];
			if (ao != null) {
				setUpdateOperationFieldData(ao, "modify_user");
			}
		}
	}
	
	private void setCreateOperationFieldData(Object obj, String username) {
		Class<?> clazz = obj.getClass();
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				if ("createUsername".equals(field.getName())) {
					boolean isAccessible = field.isAccessible();
					if (!isAccessible) {
						field.setAccessible(true);
					}
					try {
						field.set(obj, username);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					} finally {
						if (!isAccessible) {
							field.setAccessible(false);
						}
					}
				} else if ("createTime".equals(field.getName())) {
					boolean isAccessible = field.isAccessible();
					if (!isAccessible) {
						field.setAccessible(true);
					}
					try {
						field.set(obj, new Timestamp(new Date().getTime()));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					} finally {
						if (!isAccessible) {
							field.setAccessible(false);
						}
					}
				}
			}
		}
	}
	
	private void setUpdateOperationFieldData(Object obj, String username) {
		Class<?> clazz = obj.getClass();
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				if ("modifyUsername".equals(field.getName())) {
					boolean isAccessible = field.isAccessible();
					if (!isAccessible) {
						field.setAccessible(true);
					}
					try {
						field.set(obj, username);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					} finally {
						if (!isAccessible) {
							field.setAccessible(false);
						}
					}
				} else if ("modifyTime".equals(field.getName())) {
					boolean isAccessible = field.isAccessible();
					if (!isAccessible) {
						field.setAccessible(true);
					}
					try {
						field.set(obj, new Timestamp(new Date().getTime()));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					} finally {
						if (!isAccessible) {
							field.setAccessible(false);
						}
					}
				}
			}
		}
	}
}
