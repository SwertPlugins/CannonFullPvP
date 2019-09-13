package com.cannonnetwork.fullpvp.eventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.cannonnetwork.fullpvp.Main;

public class CapaceteMagicoEvents {
	
	private static Player p;
	
	public static void runRunnable() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(Main.main, new Runnable() {
			
			@Override
			public void run() {
				if (p.getInventory().getChestplate() != null && p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("§aHelme grego.")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 50, 50));
					return;
				} else {
					if (p.hasPermission("fullpvp.capavip")) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 120, 120));
						p.sendMessage("§e[HELME GREGO] §aVocê recebeu §f2 minutos §ade força, pois você é VIP.");
						return;
					}
				}
				
			}
		}, 20, 36000);
	}

}
