package com.arpit.stock.input.bakend;

import com.arpit.stock.input.model.StockData;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoBackendLoadService implements BackendLoadService{
    private MongoCollection<Document> collection;
    private static MongoBackendLoadService mongoBackendLoadService;
    @Override
    public void load(StockData record) {
        collection.insertOne(record.getDocument());
    }
    private MongoBackendLoadService(){
        init();
    }

    public static BackendLoadService getInstance(){
        if (null == mongoBackendLoadService){
            synchronized (MongoBackendLoadService.class){
                if (null == mongoBackendLoadService){
                    mongoBackendLoadService = new MongoBackendLoadService();
                }
            }
        }
        return mongoBackendLoadService;
    }

    public void init(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        //StockAnalysys
        MongoDatabase database = mongoClient.getDatabase("MarketAnalysis");
//        database.createCollection("BSEEquityData");
        collection=  database.getCollection("BSEEquityData");
        System.out.println("Collection sampleCollection selected successfully");
    }
}
