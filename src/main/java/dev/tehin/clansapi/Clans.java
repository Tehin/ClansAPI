package dev.tehin.clansapi;

import org.bukkit.plugin.java.JavaPlugin;

import dev.tehin.clansapi.clan.manager.ClansManager;
import dev.tehin.clansapi.commands.DebugCmd;
import dev.tehin.clansapi.database.MongoDB;
import dev.tehin.clansapi.player.manager.PlayerManager;

public class Clans extends JavaPlugin {
	
    // Instances
	private static Clans instance;
	
	private MongoDB mongodb;
	private ClansManager clansManager;
	private PlayerManager playerManager;
	
	@Override
	public void onEnable() {
		// Instances
		instance = this;
		this.mongodb = new MongoDB();
		
		this.clansManager = new ClansManager();
		this.playerManager = new PlayerManager();
		
		// Set-Up
		loadCommands();
		loadConfigs();
		loadDatabase();
	}
	
	// Set-Up
	private void loadCommands() {
		getCommand("debug").setExecutor(new DebugCmd());
	}
	
	private void loadConfigs() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	private void loadDatabase() {
		this.mongodb.connect(getConfig().getString("database.connection-uri"));
	}
    
	// Instances
	public static Clans getInstance() {
		return instance;
	}
	
	public MongoDB getDB() {
		return this.mongodb;
	}
	
	public ClansManager getClansManager() {
		return this.clansManager;
	}
	
	public PlayerManager getPlayerManager() {
		return this.playerManager;
	}
	

}
