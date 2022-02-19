package dev.tehin.clansapi.utils;

import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

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
	
}
