package dev.tehin.clansapi.player;

import java.util.UUID;

import org.bukkit.entity.Player;

import dev.tehin.clansapi.clan.Clan;
import dev.tehin.clansapi.clan.roles.ClanRole;

public class PlayerData {
	
	private Clan clan;
	private ClanRole role;
	private Player player;
	
	public PlayerData(Player player) {
		this.player = player;
		this.clan = ""; // TOOD
		this.role = clan.getRole(getUUID());
	}

	public Clan getClan() {
		return clan;
	}

	public ClanRole getRole() {
		return role;
	}

	public Player getPlayer() {
		return player;
	}
	
	public UUID getUUID() {
		return this.player.getUniqueId();
	}

}
