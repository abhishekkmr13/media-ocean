package com.prokabbadi.model;

public class Team {

	private String name;
	private String home;
	
	public Team(String name, String home) {
		super();
		this.name = name;
		this.home = home;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Team)obj).getName());
	}
	@Override
	public String toString() {
		return "Team [name=" + name + "]";
	}
	
	
}
