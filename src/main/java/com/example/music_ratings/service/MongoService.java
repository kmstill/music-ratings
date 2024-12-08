package com.example.music_ratings.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class MongoService {

    public void callMongo() {
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("kmstill");
            MongoCollection<Document> collection = database.getCollection("Albums");
            database.createCollection("testCollection");

            Document doc = collection.find(eq("title", "OK Computer")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }


    }
}
