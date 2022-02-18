package dev.tehin.clansapi;

import org.bukkit.plugin.java.JavaPlugin;

import dev.tehin.clansapi.clan.manager.ClansManager;
import dev.tehin.clansapi.commands.DebugCmd;

public class Clans extends JavaPlugin {
	
    // Instances
	public static Clans instance;
	
	private ClansManager clansManager;
	
	@Override
	public void onEnable() {
		// Instances
		instance = this;
		clansManager = new ClansManager();
		
		// Set-Up
		loadCommands();
		loadConfigs();
	}
	
	// Set-Up
	private void loadCommands() {
		getCommand("debug").setExecutor(new DebugCmd());
	}
	
	public void loadConfigs() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
    
	// Instances
	public static Clans getInstance() {
		return instance;
	}
	
	public ClansManager getClansManager() {
		return this.clansManager;
	}

}
