package dev.tehin.clansapi.clan;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

import dev.tehin.clansapi.Clans;
import dev.tehin.clansapi.clan.roles.ClanRole;
import dev.tehin.clansapi.exceptions.ClanNotFoundException;
import dev.tehin.clansapi.exceptions.MemberNotFoundException;
import dev.tehin.clansapi.exceptions.MembersLimitException;
import dev.tehin.clansapi.exceptions.NoLeaderException;

public class Clan {
	
	private String name;
	private String prefix;
	private boolean open;
	private int maxMembers = Clans.getInstance().getConfig().getInt("max-members");
	
	private UUID leader;
	private ArrayList<UUID> captains = new ArrayList<>();
	private ArrayList<UUID> members = new ArrayList<>();
	
	private ArrayList<UUID> playersOnline = new ArrayList<>();
	
	private double coins = Clans.getInstance().getConfig().getDouble("default-coins");
	private String nextClanWar = "";
	
	public Clan(UUID leader, String name, boolean open) {
		this.leader = leader;
		this.name = name;
		this.open = open;
	}
	
	public Clan(UUID leader, String name, boolean open, int maxMembers) {
		this.leader = leader;
		this.name = name;
		this.open = open;
		
		this.maxMembers = maxMembers;
	}
	
	// Methods
	public void create() {
		Clans.getInstance().getClansManager().createClan(this);
	}
	
	public void disband() {
		// TODO
	}
	
	public void addMember(Player player) throws MembersLimitException {
		if (getTotalMembers() == maxMembers) throw new MembersLimitException();
		
		members.add(player.getUniqueId());
	}
	
	public void addCoins(int amount) {
		this.coins += amount;
	}
	
	public void substractCoins(int amount) {
		this.coins -= amount;
	}
	
	
	// Getters
	public UUID getLeader() {
		return leader;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public int getMaxMembers() {
		return this.maxMembers;
	}
	
	public String getPrefix() {
		return this.prefix;
	}
	
	public int getTotalMembers() {
		// The "+ 1" refers to the leader.
		return (captains.size() + members.size() + 1);
	}
	
	public ArrayList<UUID> getAllMembersUUID() {
		ArrayList<UUID> marged = new ArrayList<>();
		
		marged.addAll(captains);
		marged.addAll(members);
		marged.add(leader);
		
		return marged;
	}
	
	public ArrayList<UUID> getNumberMembers() {
		return this.members;
	}
	
	public double getCoins() {
		return coins;
	}
	
	public ClanRole getRole(UUID uuid) {
		if (leader.equals(uuid)) return ClanRole.LEADER;
		if (captains.contains(uuid)) return ClanRole.CAPTAIN;
		
		return ClanRole.MEMBER;
	}
	
	public String getNextClanWar() {
		return this.nextClanWar;
	}
	
	// Setters
	@SuppressWarnings("incomplete-switch")
	private void setLeader(UUID newLeader) {
		ClanRole currentRole = getRole(newLeader);
		switch(currentRole) {
			case CAPTAIN:
				captains.remove(newLeader);
				break;
			case MEMBER:
				members.remove(newLeader);
				break;
		}
		
		captains.add(this.leader); // Automatically demotes the leader to captain.
		
		this.leader = newLeader;
		
	}
	
	public void setRole(UUID member, ClanRole newRole) throws MemberNotFoundException, NoLeaderException {
		if (!getAllMembersUUID().contains(member)) throw new MemberNotFoundException();
		
		ClanRole currentRole = getRole(member);
		
		if (currentRole.equals(newRole)) return; // There is no reason to set the same role.
		if (currentRole.equals(ClanRole.LEADER)) throw new NoLeaderException(); // If you change the role to the leader, the clan would be leaderless.
					
		switch(newRole) {
			case LEADER:
				setLeader(member);
				break;
			case CAPTAIN:
				captains.add(member);
				members.remove(member);
				break;
			case MEMBER:
				captains.remove(member);
				members.add(member);
				break;
		}
	}
	
	public void setNextClanWar(String clanName) throws ClanNotFoundException {
		if (clanName == null) this.nextClanWar = "";
		if (Clans.getInstance().getClansManager().clanExists(clanName)) throw new ClanNotFoundException("That clan does not exist, so you cannot have a clan war against them.");
	
		this.nextClanWar = clanName;
	}
	
	public void setCoins(double coins) {
		this.coins = coins;
	}
	
	public void setMaxMembers(int amount) {
		this.maxMembers = amount;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setOnline(UUID uuid, boolean online) {
		if (online) playersOnline.add(uuid);
		else playersOnline.remove(uuid);
	}
}
