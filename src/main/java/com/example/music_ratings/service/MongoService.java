package com.example.music_ratings.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;

import static com.mongodb.client.model.Filters.eq;

@Service
@RequiredArgsConstructor
public class MongoService {

    private final MongoClient mongoClient;

    public void callMongo() {
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
