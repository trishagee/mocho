package com.mechanitis.mocho;

public class MongoDatabase {
    private final org.mongodb.MongoDatabase delegate;

    MongoDatabase(final org.mongodb.MongoDatabase database) {
        this.delegate = database;
    }

    public MongoCollection getCollection(final String collectionName) {
        org.mongodb.MongoCollection collection = delegate.getCollection(collectionName);
        return new MongoCollection(collection);
    }

    public void dropDatabase() {
        delegate.tools().drop();
    }
}
