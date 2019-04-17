package com.prokabbadi.model;

public class Schedule {
	
	private Match match1;
	private Match match2;
	
	
	public Match getMatch1() {
		return match1;
	}
	public void setMatch1(Match match1) {
		this.match1 = match1;
	}
	public Match getMatch2() {
		return match2;
	}
	public void setMatch2(Match match2) {
		this.match2 = match2;
	}
	
	
	public boolean isTeamPlaying(Team t) {
		
		if(null != match1 && (match1.getOpponent1().equals(t)
				|| match1.getOpponent2().equals(t))) {
			return true;
		}else if (null != match2 && (match2.getOpponent1().equals(t)
				|| match2.getOpponent2().equals(t))) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Schedule [match1=" + match1 + ", match2=" + match2 + "]\n";
	}
	
	
}
