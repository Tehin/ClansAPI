package dev.tehin.clansapi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DebugCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		
//		if (args[0].equalsIgnoreCase("init")) {
//			Bukkit.broadcastMessage("Massive clans creation started.");
//			for (int i = 0; i < 1; i++) {
//				Clan clan = new Clan(new PlayerData(player), "clan" + i, false);
//				clan.create();
//				
//				try {
//					clan.addMember(player);
//					clan.addMember(player);
//					clan.addMember(player);
//					clan.addMember(player);
//					clan.addMember(player);
//					clan.addMember(player);
//				} catch (MembersLimitException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			Bukkit.broadcastMessage("Massive clans creation finished.");
//			return true;
//		}
//		
//		if (args[0].equalsIgnoreCase("get")) {
//			Bukkit.broadcastMessage(Clans.getInstance().getClansManager().getClanByName("clan0").getMembers().get(0).toString());
//			return true;
//		}

		return false;
	}

}
