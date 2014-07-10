package com.mechanitis.mocho;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MongoCollection {
    private final DBCollection delegate;

    MongoCollection(final DBCollection collection) {
        delegate = collection;
    }

    public void insert(final Document document) {
        delegate.insert(document.getDBObject());
    }
    
    public MongoCursor find() {
        DBCursor dbCursor = delegate.find();
        return new MongoCursor(dbCursor);
    }
}
