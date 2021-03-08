package com.arpankarki.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {
	
	public boolean addAccount() {
		System.out.println(this.getClass()+"hey doing somme membershp dao");
		return true;
	}
	
	public void doWork() {
		System.out.println("working");
	}
}
