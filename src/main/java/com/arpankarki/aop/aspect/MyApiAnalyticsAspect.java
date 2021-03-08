package com.arpankarki.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	@Before(value = "com.arpankarki.aop.aspect.AOPExpressions.forDaoPackage()")
	public void apiAnalytics() {
		//myLogger.info("withinpackage analytics");
	}
}
