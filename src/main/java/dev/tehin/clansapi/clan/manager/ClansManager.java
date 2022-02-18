package dev.tehin.clansapi.clan.manager;

import java.util.concurrent.ConcurrentHashMap;

import dev.tehin.clansapi.clan.Clan;

public class ClansManager {
	
	private ConcurrentHashMap<String, Clan> clans = new ConcurrentHashMap<>();
	 
	public void createClan(Clan clan) {
		clans.put(clan.getName(), clan);
	}
	
	public Clan getClanByName(String name) {
		return clans.get(name);
	}
	
	public boolean clanExists(String name) {
		return (getClanByName(name) != null);
	}
	

}
