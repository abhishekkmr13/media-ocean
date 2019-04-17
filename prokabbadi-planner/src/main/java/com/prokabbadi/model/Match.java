package com.prokabbadi.model;

public class Match {

	private Team opponent1;
	private Team opponent2;
	private String venue;
	private int day;
	
	public Match(Team oponent1, Team oponent2) {
		super();
		this.opponent1 = oponent1;
		this.opponent2 = oponent2;
	}
	public Team getOpponent1() {
		return opponent1;
	}
	public void setOpponent1(Team oponent1) {
		this.opponent1 = oponent1;
	}
	public Team getOpponent2() {
		return opponent2;
	}
	public void setOpponent2(Team oponent2) {
		this.opponent2 = oponent2;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	@Override
	public String toString() {
		return "Match [ "+opponent1 + " Vs "+ opponent2 + ", at " + venue + "]";
	}

	
	
	
}
