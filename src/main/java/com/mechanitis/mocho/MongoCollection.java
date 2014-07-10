package com.mechanitis.mocho;

public class MongoCollection {
    private final org.mongodb.MongoCollection<org.mongodb.Document> delegate;

    MongoCollection(final org.mongodb.MongoCollection collection) {
        delegate = collection;
    }

    public void insert(final Document document) {
        delegate.insert(document.getDocument());
    }
    
    public MongoView find() {
        org.mongodb.MongoView<org.mongodb.Document> mongoView = delegate.find();
        return new MongoView(mongoView);
    }
}
