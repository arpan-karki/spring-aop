package com.arpankarki.aop.domain;

import javax.persistence.Entity;

@Entity
public class Account {
	private String name, level;

	public Account() {
		super();
	}

	public Account(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}

	public String getName() {
		//myLogger.info("In getter Name");
		return name;
	}

	public void setName(String name) {
		//myLogger.info("In setter Name");
		this.name = name;
	}

	public String getLevel() {
		//myLogger.info("In getter Level");
		return level;
	}

	public void setLevel(String level) {
		//myLogger.info("In setter level");
		this.level = level;
	}

}
