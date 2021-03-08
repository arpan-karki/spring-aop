package com.arpankarki.aop;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arpankarki.aop.dao.AccountDAO;
import com.arpankarki.aop.dao.MemberShipDAO;
import com.arpankarki.aop.domain.Account;
import com.fasterxml.classmate.AnnotationConfiguration;

public class MainDemoApp {

	private static Logger myLogger = Logger.getLogger(MainDemoApp.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
				DemoConfig.class);

		AccountDAO accountDAO = annotationConfigApplicationContext.getBean("accountDAO", AccountDAO.class);

		Account account = new Account("name", "level");
		accountDAO.addAccount(account, true);
		accountDAO.addAccount(account, false);
		accountDAO.addAccount(account, false);
		accountDAO.doWork();
		account.setLevel("a");
		account.setName("name");

		account.getLevel();
		account.getLevel();

		MemberShipDAO memberShipDAO = annotationConfigApplicationContext.getBean("memberShipDAO", MemberShipDAO.class);

		memberShipDAO.addAccount();
		memberShipDAO.addAccount();
		memberShipDAO.addAccount();
		memberShipDAO.doWork();

		List<Account> accounts = accountDAO.getAccounts();

		// accountDAO.exceptionMethod();
		try {
			accountDAO.exceptionMethod();
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e);
		}
		annotationConfigApplicationContext.close();

	}

}
