package com.cannonnetwork.fullpvp.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cannonnetwork.fullpvp.enums.FullPvPSystem;
import com.cannonnetwork.fullpvp.object.FullPvPObject;

public class SetarPickExplosivaComando implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;

		if (!(p.hasPermission("fullpvp.item"))) {
			p.sendMessage("§cVocê precisa do cargo Gerente ou superior para utilizar este comando.");
			return true;

		}
		if (args.length != 3) {
			p.sendMessage("§cUtilize o comando corretamente: /setaritem <jogador> <item> <quantidade>.");
			return true;
		}
		Player p1 = Bukkit.getPlayer(args[0]);
		String item = args[1];
		@SuppressWarnings("unused")
		int quantidade;

		if (isInteger(args[2])) {
			quantidade = Integer.parseInt(args[2]);
		} else {
			p.sendMessage("§cSua quantidade é inválida.");
			return true;
		}
		if (p1 == null) {
			p.sendMessage("§cEste jogador está offline.");
			return true;
		}
		switch (item.toLowerCase()) {
		case "picareta": {
			FullPvPObject.adicionarPlayerItem(FullPvPSystem.EXPLOSIVA, p1);
			p.sendMessage("§aO item customizado §fPicareta explosiva §afoi givada ao jogador §f" + p1.getName());
			break;
		}
		case "capacete": {
			FullPvPObject.adicionarPlayerItem(FullPvPSystem.MAGICO, p1);
			p.sendMessage("§aO item customizado §fCapacete do mago §afoi givada ao jogador §f" + p1.getName());
			break;
		}
		default: {

			p.sendMessage("§cSua quantidade é inválida.");
			break;
		}
		}

		return false;
	}

	private boolean isInteger(String s) {

		try {
			Integer.parseInt(s);
			return true;

		} catch (NumberFormatException ex) {

			return false;
		}
	}

}
