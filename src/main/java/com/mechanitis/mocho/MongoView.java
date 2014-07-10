package com.mechanitis.mocho;

import org.mongodb.Document;

public class MongoView {
    private final org.mongodb.MongoView<Document> delegate;

    public MongoView(final org.mongodb.MongoView<Document> mongoView) {
        delegate = mongoView;
    }

    public long count() {
        return delegate.count();
    }
}
