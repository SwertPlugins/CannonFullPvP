package com.cannonnetwork.fullpvp.metodos;

import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.cannonnetwork.fullpvp.api.ScoreBoardPlayerOff;

public class ScoreLineMetodos {

	private Scoreboard sb;
	private Objective obj;

	public ScoreLineMetodos(Scoreboard sb, Objective obj) {
		this.sb = sb;
		this.obj = obj;
	}

	@SuppressWarnings("deprecation")
	public void addLine(String prefix, String center, String suffix, int index) {
		Team t = sb.registerNewTeam("line" + index);
		t.setPrefix(prefix);
		t.setSuffix(suffix);
		ScoreBoardPlayerOff fast = new ScoreBoardPlayerOff(center);
		t.addPlayer(fast);
		obj.getScore(fast.getName()).setScore(index);
	}

}