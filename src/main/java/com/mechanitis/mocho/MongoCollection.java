package com.mechanitis.mocho;

import java.util.stream.Stream;

public class MongoCollection {
    private final org.mongodb.MongoCollection<org.mongodb.Document> delegate;

    MongoCollection(final org.mongodb.MongoCollection collection) {
        delegate = collection;
    }

    public void insert(final Document document) {
        delegate.insert(document.getDocument());
    }
    
    public Stream<Document> stream() {
        return new DocumentStream(delegate);
    }
}
