package com.arpankarki.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // Just a java class with collection of advices
@Component
public class MyDemoLoggingAspect {
	
	
	
	@Before(value = "execution(public void com.arpankarki.aop.dao.AccountDAO.addAccount())")
	public void beforeaddAccountAdvice() {
		//myLogger.info("/n======> Executing @before on addAccount ");
	}
	
	@Before(value = "execution( public * add*())")
	public void beforAddAdvice() {
		//myLogger.info("/n======> Executing @before  add* ");
	}
	
	@Before(value = "execution(* addAccount(com.arpankarki.aop.domain.Account,..))")
	public void beforeaddAccountAdviceWithParams() {
		//myLogger.info("/n======> Executing @before on parameter aspect ");
	}
	
	@Before(value = "execution( * add*(..))")
	public void beforeAnyAddAlways() {
		//myLogger.info("All");
	}
	
	@Before(value = "com.arpankarki.aop.aspect.AOPExpressions.forDaoPackage()")
	public void beforeOnlyWithinPackage() {
		//myLogger.info("withinpackage");
	}
	
	@Before(value = "com.arpankarki.aop.aspect.AOPExpressions.forDaoPackage()")
	public void apiAnalytics() {
		//myLogger.info("withinpackage analytics");
	}
	
	@Before(value = "com.arpankarki.aop.aspect.AOPExpressions.forGetters()")
	public void forGetter() {
		//myLogger.info("In getters");
	}
	
	@Before(value = "com.arpankarki.aop.aspect.AOPExpressions.forSetters()")
	public void forSetter() {
		//myLogger.info("In setters");
	}
	
	@Before(value = "com.arpankarki.aop.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void forGettersInPackage() {
		//myLogger.info("forDaoPackageNoGetterSetter");
	}
	@Before(value = "com.arpankarki.aop.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void logtoCloudAsync() {
		//myLogger.info("Log to cloud async");
	}
}
