package com.arpankarki.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

	@Pointcut("execution(* com.arpankarki.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.arpankarki.aop.dao.*.get*(..))")
	public void forGetters() {
	}

	@Pointcut("execution(* com.arpankarki.aop.dao.*.set*(..))")
	public void forSetters() {
	}

	@Pointcut("forDaoPackage() && !(forGetters() || forSetters()) ")
	public void forDaoPackageNoGetterSetter() {
	}
}
