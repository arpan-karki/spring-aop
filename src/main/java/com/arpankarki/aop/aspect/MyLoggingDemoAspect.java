package com.arpankarki.aop.aspect;

import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.arpankarki.aop.domain.Account;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Before(value = "execution(public void com.arpankarki.aop.dao.AccountDAO.addAccount(..))")
	public void beforeaddAccountAdvice(JoinPoint joinPoint) {
		myLogger.info("/n======> Executing @before on addAccount ");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		myLogger.info("Method : " + methodSignature);

		Object[] args = joinPoint.getArgs();

		for (Object tempArg : args) {
			myLogger.info(tempArg);
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				myLogger.info("account name :" + account.getName());
				myLogger.info("account name :" + account.getLevel());
			}
		}

	}

	@AfterReturning(pointcut = "execution(public * com.arpankarki.aop.dao.AccountDAO.getAccounts())", returning = "result")
	public void afterreturningAccounts(JoinPoint joinPoint, List<Account> result) {
		myLogger.info("Execution after returning ");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		myLogger.info("Method:" + methodSignature);

		for (Account account : result) {
			myLogger.info(account);
		}

	}

	@AfterThrowing(pointcut = "execution(public *  com.arpankarki.aop.dao.AccountDAO.exceptionMethod())", throwing = "exception")
	public void afterThrowingExceptio(JoinPoint joinPoint, Exception exception) {
		myLogger.info("Executing after exception Thrown");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		myLogger.info("Method:" + methodSignature);
		myLogger.info("Exception:" + exception);
	}

	@After(value = "execution(public *  com.arpankarki.aop.dao.AccountDAO.exceptionMethod())")
	public void afterMethod(JoinPoint joinPoint) {
		myLogger.info("Executing after the method");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		myLogger.info("Method:" + methodSignature);
	}

	@Around(value = "execution(public *  com.arpankarki.aop.dao.AccountDAO.exceptionMethod())")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Executing around advice");
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		Object object = null;
		try {
			long begin = System.currentTimeMillis();
			object = proceedingJoinPoint.proceed();
			System.out.println("Object " + object);
			long end = System.currentTimeMillis();
			long duration = end - begin;
			System.out.println("Time :" + duration / 1000);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("Method:" + methodSignature);
			object = "Caught Exception";
			throw e;
		}
		return object;

	}

}
