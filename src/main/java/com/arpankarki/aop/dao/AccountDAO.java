package com.arpankarki.aop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.arpankarki.aop.domain.Account;

@Component
public class AccountDAO {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	public void addAccount(Account account,boolean vipFlag ) {
		myLogger.info(this.getClass() + "Adding account");
	}
	
	public void doWork() {
		myLogger.info("Sleep");
	}
	
	public List<Account> getAccounts(){
		List<Account> accounts = new ArrayList<Account>();
		Account account1 = new Account("one", "level");
		Account account2= new Account("two", "level");
		Account account3 = new Account("three", "level");
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		return accounts;
	}
	
	public void exceptionMethod() throws Exception {
		/*
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch(InterruptedException e) {
			throw e;
		}*/
		Exception exception = new Exception("Testing throws");
		throw exception;
	}
}
