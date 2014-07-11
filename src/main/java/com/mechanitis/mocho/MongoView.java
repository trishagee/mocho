package com.mechanitis.mocho;

import org.mongodb.MongoIterable;

public class MongoView {
    private final org.mongodb.MongoView<Document> delegate;

    public MongoView(final org.mongodb.MongoView<Document> mongoView) {
        delegate = mongoView;
    }

    public long count() {
        return delegate.count();
    }

    public Document getOne() {
        Document found = delegate.getOne();
        return new Document(found);
    }

    public MongoIterable<Object> sort(final org.mongodb.Document id) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
