package com.cannonnetwork.fullpvp.object;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.cannonnetwork.fullpvp.api.FullPvPAPI;
import com.cannonnetwork.fullpvp.enums.FullPvPSystem;

public class FullPvPObject {

	public static void adicionarPlayerItem(FullPvPSystem itemtype, Player p) {
		switch (itemtype) {
		case EXPLOSIVA:
			ItemStack explosiva = new ItemStack(Material.DIAMOND_PICKAXE);
			ItemMeta meta = explosiva.getItemMeta();
			List<String> lore = new ArrayList<>();
			if (meta.hasLore()) {
				lore.addAll(meta.getLore());
			}
			meta.setDisplayName("§aPicareta Explosiva.");
			lore.add("");
			lore.add("§8• §fRaridade: §e★★★★★");
			lore.add("§8• §fFunção: §eUma picareta que explode blocos.");
			lore.add("");
			lore.add("  §aDisponivel na loja de bitcoin.");
			lore.add("");

			FullPvPAPI api = new FullPvPAPI(1200);

			meta.addEnchant(api, 1, true);
			meta.setLore(lore);
			explosiva.setItemMeta(meta);

			p.getInventory().addItem(explosiva);
			break;
		case MAGICO:
			ItemStack magico = new ItemStack(Material.DIAMOND_HELMET);
			ItemMeta meta1 = magico.getItemMeta();
			List<String> lore1 = new ArrayList<>();
			if (meta1.hasLore()) {
				lore1.addAll(meta1.getLore());
			}
			meta1.setDisplayName("§aHelme grego.");
			lore1.add("");
			lore1.add("§8• §fRaridade: §e★★★★★");
			lore1.add("§8• §fFunção: §eGanhe §f1 minuto §ede força.");
			lore1.add("");
			lore1.add(" §bJogadores VIP ganham §f2 minutos §bde força.");
			lore1.add("");
			lore1.add("  §aItem disponivel na loja de bitcoin.");
			lore1.add("");

			FullPvPAPI api1 = new FullPvPAPI(1200);

			meta1.addEnchant(api1, 1, true);
			meta1.setLore(lore1);
			magico.setItemMeta(meta1);

			p.getInventory().addItem(magico);
			break;
		default:
			break;
		}
	}

}
