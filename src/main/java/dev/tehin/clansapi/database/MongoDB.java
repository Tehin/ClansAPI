package dev.tehin.clansapi.database;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dev.tehin.clansapi.utils.Utils;

public class MongoDB {
	private MongoCollection<Document> clansData, playersData;
	private MongoClient client;
	private MongoDatabase db;

	public void connect(String connectionURI) {
		Utils.sendConsole("&7[ClansAPI] &fConnecting to Mongo Database...");
		
		try {
			MongoClientURI uri = new MongoClientURI(connectionURI);
			this.client = new MongoClient(uri);
			this.db = client.getDatabase("ClansAPI");
			
			this.clansData = db.getCollection("clans_data");
			this.playersData = db.getCollection("players_data");
		} catch (Exception e) {
			Utils.sendConsole("&7[ClansAPI] &cCould not connect to Mongo Database: ");
			e.printStackTrace();
		}
		
	}
	
	public MongoCollection<Document> getPlayers() {
		return this.playersData;
	}
	
	public MongoCollection<Document> getClans() {
		return this.clansData;
	}
}
