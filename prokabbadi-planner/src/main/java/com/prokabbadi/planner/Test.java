package com.prokabbadi.planner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.prokabbadi.model.Schedule;
import com.prokabbadi.model.Team;

public class Test {

	public static void main(String[] args) {
			List<Team> teamList = new ArrayList<Team>();
			teamList.add(new Team("Team-A", "A"));
			teamList.add(new Team("Team-B", "B"));
			teamList.add(new Team("Team-C", "C"));
			teamList.add(new Team("Team-D", "D"));
			teamList.add(new Team("Team-E", "E"));
			teamList.add(new Team("Team-F", "F"));
			teamList.add(new Team("Team-G", "G"));
			teamList.add(new Team("Team-H", "H"));

			
			EventPlanner<List<Team>, Map<Integer, Schedule>> eventPlanner = new RoundrobinPlanner();
			System.out.println(eventPlanner.plan(teamList));
	}

}
