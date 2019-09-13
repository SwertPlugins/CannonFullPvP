package com.cannonnetwork.fullpvp.api;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

public class CitizensNPCAPI {
	
	@SuppressWarnings("static-access")
	public static void criarNpc(Location spawnar, String nome, String skin, Player p) {
		NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, p.getUniqueId(), 0, nome);
		npc.data().setPersistent(npc.PLAYER_SKIN_USE_LATEST, false);
		npc.data().setPersistent(npc.PLAYER_SKIN_UUID_METADATA, skin);
		npc.spawn(spawnar);
		p.sendMessage("§aVocê spawnou o npc " + nome + " §acom sucesso.");
		return;
	}

}
