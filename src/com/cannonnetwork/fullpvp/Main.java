package com.cannonnetwork.fullpvp;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.cannonnetwork.fullpvp.api.FullPvPAPI;
import com.cannonnetwork.fullpvp.comandos.SetarPickExplosivaComando;
import com.cannonnetwork.fullpvp.eventos.CapaceteMagicoEvents;
import com.cannonnetwork.fullpvp.eventos.PickExplosivaEvents;
import com.cannonnetwork.fullpvp.score.CannonScoreboard;

import net.milkbowl.vault.economy.Economy;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

public class Main extends JavaPlugin {
	
	public static Main main;
	public static Economy vault;
	
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager()
				.getRegistration(Economy.class);
		if (economyProvider != null) {
			vault = economyProvider.getProvider();
		}

		return (vault != null);
	}
	
	@SuppressWarnings("deprecation")
	public static double getCoins(String jogador) {
		return vault.getBalance(jogador);
	}
	
	public static double getCoinsJogador(Player p) {
		if (getCoins(p.getName()) == 10000000000.0) {
			return 1000000000.0;
		} else {
			return getCoins(p.getName());
		}
	}
	public static String getClan(Player p) {
		if (SimpleClans.getInstance().getClanManager().getClanPlayer(p) == null) {
			return " §7Nenhum.";
		} else {
			return " " + SimpleClans.getInstance().getClanManager().getClanPlayer(p).getTag().toUpperCase();
		}
	}
	
	@Override
	public void onEnable() {
		main = this;
		
		registrarItem();
		CapaceteMagicoEvents.runRunnable();
		
		getCommand("setaritem").setExecutor(new SetarPickExplosivaComando());
		Bukkit.getPluginManager().registerEvents(new PickExplosivaEvents(), this);
		Bukkit.getPluginManager().registerEvents(new CannonScoreboard(), this);
		setupEconomy();
		
		Bukkit.getConsoleSender().sendMessage("§e[FULL PVP] §aPlugin habilitado.");
	}
	public void registrarItem() {
		try {
			Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
		} catch (Exception e) {
			e.printStackTrace();
		} try {
			FullPvPAPI api = new FullPvPAPI(70);
			Enchantment.registerEnchantment(api);
		} catch (IllegalArgumentException a) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
