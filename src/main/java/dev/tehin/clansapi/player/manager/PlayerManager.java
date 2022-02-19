package dev.tehin.clansapi.player.manager;

import org.bson.Document;
import org.bukkit.entity.Player;

import dev.tehin.clansapi.Clans;
import dev.tehin.clansapi.clan.Clan;

public class PlayerManager {
	
	public Clan loadClanFromDatabase(Player player) {
		Document filter = new Document("UUID", player.getUniqueId());
		Document result = Clans.getInstance().getDB().getPlayers().find(filter).first();
		
		String clanName = result.getString("Clan");
		
		if (clanName == null) return null;
		
		Clan clan = Clans.getInstance().getClansManager().getClanByName(result.getString("Clan"));
		return clan;
	}

}
