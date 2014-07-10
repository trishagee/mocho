package com.mechanitis.mocho;

public class MongoClientURI {
    private final org.mongodb.MongoClientURI delegate;

    public MongoClientURI(final String uri) {
        delegate = new org.mongodb.MongoClientURI(uri);
    }

    org.mongodb.MongoClientURI getMongoURI() {
        return delegate;
    }
}
