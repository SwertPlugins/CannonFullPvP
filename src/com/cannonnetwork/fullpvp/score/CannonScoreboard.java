package com.cannonnetwork.fullpvp.score;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.cannonnetwork.fullpvp.Main;
import com.cannonnetwork.fullpvp.metodos.ScoreLineMetodos;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CannonScoreboard implements Listener {

	NumberFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
	
	public CannonScoreboard() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for (Player ons : Bukkit.getOnlinePlayers()) {
					atualizarScore(ons);
				}
			}
		}.runTaskTimerAsynchronously(Main.main, 0L, 10L);
	}

	public void criarScoreBoard(Player p) {
		Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = score.registerNewObjective("score", "dummy");

		obj.setDisplayName(" §b§lFULL §f§lPVP ");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		ScoreLineMetodos line = new ScoreLineMetodos(score, obj);

		String prefix = PermissionsEx.getUser(p).getPrefix().replace("&", "§");

		line.addLine("", "   §7Temporada #1", "", 10);
		line.addLine("", "§0", "", 9);
		line.addLine("", " §fCargo: ", prefix, 8);
		line.addLine("", " §fClan: §7", Main.getClan(p), 7);
		line.addLine("", "§1", "", 6);
		line.addLine("", " §fCoins: §7", nf.format(Main.getCoinsJogador(p)), 5);
		line.addLine("", " §fCash: §7", "0.0", 4);
		line.addLine("", " §fBitCoin: §7", "0.0", 3);
		line.addLine("", "§2", "", 2);
		line.addLine("", " §ewww.cannonnetwork", ".com", 1);
		
		p.setScoreboard(score);
	}
	public void atualizarScore(Player p) {
		String prefix = PermissionsEx.getUser(p).getPrefix().replace("&", "§");
		Scoreboard score = p.getScoreboard();
		if (score.getObjective("score") != null) {
			
			Team cargo = score.getTeam("line8");
			cargo.setSuffix(prefix);
			
			Team clan = score.getTeam("line7");
			clan.setSuffix(Main.getClan(p));
			
			Team coins = score.getTeam("line5");
			coins.setSuffix(nf.format(Main.getCoinsJogador(p)) + "");
		}
	}
	@EventHandler
	public void playerScoreEvent(PlayerJoinEvent e) {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				criarScoreBoard(e.getPlayer());
				
			}
		}.runTaskLater(Main.main, 20L * 5L);
	}
}
