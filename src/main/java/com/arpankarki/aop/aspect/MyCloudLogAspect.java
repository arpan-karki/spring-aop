package com.arpankarki.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {
	@Before(value = "com.arpankarki.aop.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void logtoCloudAsync() {
		//myLogger.info("Log to cloud async");
	}
}
