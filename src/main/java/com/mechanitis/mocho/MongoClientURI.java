package com.mechanitis.mocho;


public class MongoClientURI {
    private com.mongodb.MongoClientURI delegate;

    public MongoClientURI(final String uri) {
        delegate = new com.mongodb.MongoClientURI(uri);
    }

    com.mongodb.MongoClientURI getMongoURI() {
        return delegate;
    }
}
