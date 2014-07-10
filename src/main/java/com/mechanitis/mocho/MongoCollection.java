package com.mechanitis.mocho;

import com.mongodb.DBCollection;

public class MongoCollection {
    private final DBCollection delegate;

    MongoCollection(final DBCollection collection) {
        delegate = collection;
    }
}
