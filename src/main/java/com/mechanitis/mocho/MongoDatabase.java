package com.mechanitis.mocho;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public class MongoDatabase {
    private final DB delegate;

    MongoDatabase(final DB database) {
        this.delegate = database;
    }

    public MongoCollection getCollection(final String collectionName) {
        DBCollection collection = delegate.getCollection(collectionName);
        return new MongoCollection(collection);
    }
}
