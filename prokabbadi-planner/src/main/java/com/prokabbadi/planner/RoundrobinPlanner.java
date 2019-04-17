package com.prokabbadi.planner;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.prokabbadi.model.Match;
import com.prokabbadi.model.Schedule;
import com.prokabbadi.model.Team;
import com.prokabbadi.util.SlotEnum;

public class RoundrobinPlanner implements EventPlanner<List<Team>, Map<Integer, Schedule>>{

	private Map<Integer, Schedule> matchSchedule = new TreeMap<Integer, Schedule	>();

	@Override
	public Map<Integer, Schedule> plan(List<Team> teamList){

		//Total number matches possible for n teams, n(n-1)
		for(int i=0; i<teamList.size(); i++) {

			Team team1 = teamList.get(i);

			System.out.println("============= Planning all matches for ["+team1+"]===============");

			//Find opponent
			for(int j=0; j<teamList.size(); j++) {

				//Team cannot play with themselves
				if(i==j)
					continue;

				Team team2 = teamList.get(j);
				schedule(team1, team2);
			}

			System.out.println(matchSchedule);
			System.out.println("=============END===============");
		}

		System.out.println(matchSchedule);

		return matchSchedule;
	}

	
	/***
	 * Method responsible for creating match schedule
	 * 
	 * @param team1 Opponent1
	 * @param team2 Opponent2
	 */
	public void schedule(Team team1, Team team2) {

		Integer max = matchSchedule.keySet()
				.stream()
				.reduce(Integer::max)
				.orElse(0);

		System.out.println("----------------------------------------------------");
		System.out.println("Scheduling for ="+team1.getHome()+" "+team2.getHome()+" MAX=["+max+"]");
		System.out.println("----------------------------------------------------");

		int day=0;
		
		//Iterate to find right spot for the match to happen
		while(day<=max) {

			//Identify the possibility for that day
			SlotEnum slotEnum = getAvailableSlot(day, team1, team2);

			if(slotEnum.getValue() == SlotEnum.NO_SCHEDULE_AVAILABLE.getValue()
					|| slotEnum.getValue() == SlotEnum.SLOTS_AVAILABLE.getValue()) {
				//Check if teams have played on previous day
				if(isTeamPlayingOnTheDay( day-1, team1) == false && isTeamPlayingOnTheDay( day-1, team2) == false) {


					//Check if teams are playing on next day
					if(isTeamPlayingOnTheDay( day+1, team1) || isTeamPlayingOnTheDay( day+1, team2) ) {

						System.out.println("Teams are already playing on next day = ["+(day+1)+"]");
						day=day+3;

						continue;
					}

					scheduleForTheDay(day, team1, team2);
					return;
				}
			}else if(slotEnum.getValue() == SlotEnum.ALREADY_PLAYING.getValue()) {
				day=day+2;
				continue;
			}

			day++;
		}
		System.out.println("Loop end with value day = ["+day+"]");

		//Check if teams have played on previous day
		if(isTeamPlayingOnTheDay( day-1, team1) || isTeamPlayingOnTheDay( day-1, team2) ) {
			day=day+2;
		}
		scheduleForTheDay(day, team1, team2);
	}

	/***
	 * Returns type of slot available for given day and opponents
	 * @param day Day on which slot is available for not
	 * @param team1	Opponent1
	 * @param team2 Opponent2
	 * @return	SlotEnum indicating type of slot available
	 */
	public SlotEnum getAvailableSlot(int day, Team team1, Team team2) {

		Schedule scheduleForTheDay = matchSchedule.get(day);
		if(scheduleForTheDay == null) {

			System.out.println("No schedule available for the day = ["+day+"]");
			return SlotEnum.NO_SCHEDULE_AVAILABLE;
		}

		//Check if teams are playing on that day
		if(isTeamPlayingOnTheDay(day, team1) || isTeamPlayingOnTheDay(day, team2)) {

			System.out.println("Team are already playing for the day = ["+day+"]");
			return SlotEnum.ALREADY_PLAYING;

		}else if(scheduleForTheDay.getMatch1() != null 
				&& scheduleForTheDay.getMatch2() != null) {
			System.out.println("Teams can play but slots not available day = ["+day+"]");
			return SlotEnum.NO_SLOTS_AVAILABLE;
		}		
		else {
			System.out.println("Slot available day="+day);
			return SlotEnum.SLOTS_AVAILABLE;
		}


	}
	
	/***
	 * Checks if team is already playing on that day
	 * 
	 * @param day 
	 * @param team1
	 * @return
	 */
	public boolean isTeamPlayingOnTheDay(int day, Team team1) {

		Schedule scheduleForTheDay = matchSchedule.get(day);

		if(null != scheduleForTheDay &&	scheduleForTheDay.isTeamPlaying(team1))
			return true;

		return false;
	}

	/***
	 * Assign the schedule
	 * 
	 * @param day
	 * @param team1
	 * @param team2
	 */
	public void scheduleForTheDay(int day, Team team1, Team team2) {

		Match match = new Match(team1, team2);
		//Venue will always be for first team in the order
		match.setVenue(team1.getHome());

		Schedule schedule = matchSchedule.get(day);

		//If there is not match, always schedule for Match1
		if(null == schedule) {
			schedule = new Schedule();
			schedule.setMatch1(match);
			System.out.println("Scheduling [Match1] on day = ["+day+"]");

		}
		//Schedule is available for MATCH-2
		else {
			System.out.println("Scheduling [Match2] on day = ["+day+"]");
			schedule.setMatch2(match);
		}

		matchSchedule.put(day, schedule);
	}

}
