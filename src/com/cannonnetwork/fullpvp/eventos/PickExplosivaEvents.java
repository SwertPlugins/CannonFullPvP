package com.cannonnetwork.fullpvp.eventos;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PickExplosivaEvents implements Listener {

	@EventHandler
	public void PickExplosiva(BlockBreakEvent e) {
		Player p = e.getPlayer();
		ItemStack stack = p.getItemInHand();
		Block block = e.getBlock();
		ItemMeta meta = stack.getItemMeta();

		if (stack.hasItemMeta() && meta.hasDisplayName() && stack.getItemMeta().getDisplayName().contains("§aPicareta Explosiva.")) {
			if (!block.getLocation().add(0.0, 0.0, -1.0).getBlock().getType().equals((Object) Material.BEDROCK) && !block.getLocation().add(-1.0, 0.0, 0.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(1.0, 0.0, 0.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(0.0, 0.0, 1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(1.0, 0.0, 1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(-1.0, 0.0, -1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(1.0, 0.0, -1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(-1.0, 0.0, 1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(0.0, -1.0, -1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(-1.0, -1.0, 0.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(1.0, -1.0, 0.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(0.0, -1.0, 1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(1.0, -1.0, 1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(-1.0, -1.0, -1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(1.0, -1.0, -1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(-1.0, -1.0, 1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(0.0, 1.0, -1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(-1.0, 1.0, 0.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(1.0, 1.0, 0.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(0.0, 1.0, 1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(1.0, 1.0, 1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(-1.0, 1.0, -1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(-1.0, 1.0, 1.0).getBlock().getType().equals((Object)Material.BEDROCK) && !block.getLocation().add(1.0, 1.0, -1.0).getBlock().getType().equals((Object)Material.BEDROCK)) {
				block.getLocation().add(0.0, 0.0, 0.0).getBlock().breakNaturally();
                block.getLocation().add(0.0, 0.0, -1.0).getBlock().breakNaturally();
                block.getLocation().add(-1.0, 0.0, 0.0).getBlock().breakNaturally();
                block.getLocation().add(1.0, 0.0, 0.0).getBlock().breakNaturally();
                block.getLocation().add(0.0, 0.0, 1.0).getBlock().breakNaturally();
                block.getLocation().add(1.0, 0.0, 1.0).getBlock().breakNaturally();
                block.getLocation().add(-1.0, 0.0, -1.0).getBlock().breakNaturally();
                block.getLocation().add(-1.0, 0.0, 1.0).getBlock().breakNaturally();
                block.getLocation().add(1.0, 0.0, -1.0).getBlock().breakNaturally();
                block.getLocation().add(0.0, -1.0, 0.0).getBlock().breakNaturally();
                block.getLocation().add(0.0, -1.0, -1.0).getBlock().breakNaturally();
                block.getLocation().add(-1.0, -1.0, 0.0).getBlock().breakNaturally();
                block.getLocation().add(1.0, -1.0, 0.0).getBlock().breakNaturally();
                block.getLocation().add(0.0, -1.0, 1.0).getBlock().breakNaturally();
                block.getLocation().add(1.0, -1.0, 1.0).getBlock().breakNaturally();
                block.getLocation().add(-1.0, -1.0, -1.0).getBlock().breakNaturally();
                block.getLocation().add(-1.0, -1.0, 1.0).getBlock().breakNaturally();
                block.getLocation().add(1.0, -1.0, -1.0).getBlock().breakNaturally();
                block.getLocation().add(0.0, 1.0, 0.0).getBlock().breakNaturally();
                block.getLocation().add(0.0, 1.0, -1.0).getBlock().breakNaturally();
                block.getLocation().add(-1.0, 1.0, 0.0).getBlock().breakNaturally();
                block.getLocation().add(1.0, 1.0, 0.0).getBlock().breakNaturally();
                block.getLocation().add(0.0, 1.0, 1.0).getBlock().breakNaturally();
                block.getLocation().add(1.0, 1.0, 1.0).getBlock().breakNaturally();
                block.getLocation().add(-1.0, 1.0, -1.0).getBlock().breakNaturally();
                block.getLocation().add(-1.0, 1.0, 1.0).getBlock().breakNaturally();
                block.getLocation().add(1.0, 1.0, -1.0).getBlock().breakNaturally();
			}
		}
	}
}
