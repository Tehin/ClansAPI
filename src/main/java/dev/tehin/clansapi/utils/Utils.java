package dev.tehin.clansapi.utils;

import java.util.List;
import java.util.UUID;

import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {
	
	/* Document Utils */
	
	public static Document updateDoc(Document document, String path, Object toInsert) {
		Document set = new Document("$set", document);
		set.append("$set", new Document(path, toInsert));

		return set;
	}
	
	/* Messages Utils */
	
	public static String toColor(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
	public static void sendConsole(String msg) {
		Bukkit.getServer().getConsoleSender().sendMessage(toColor(msg));
	}
	
	public static void sendMessageIfOnline(UUID target, String msg) {
		Player online = Bukkit.getPlayer(target);
		
		if  (online == null) return;
		online.sendMessage(Utils.toColor(msg));
	}
	
	public static void sendMessageIfOnline(UUID[] targets, String msg) {
		
		for (UUID uuid : targets) {
			Player online = Bukkit.getPlayer(uuid);
			
			if  (online == null) continue;
			online.sendMessage(Utils.toColor(msg));
		}

	}
	
	public static void sendMessageIfOnline(List<UUID> targets, String msg) {
		
		for (UUID uuid : targets) {
			Player online = Bukkit.getPlayer(uuid);
			
			if  (online == null) continue;
			online.sendMessage(Utils.toColor(msg));
		}
		
	}
}
