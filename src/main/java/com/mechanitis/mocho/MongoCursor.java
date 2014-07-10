package com.mechanitis.mocho;

public class MongoCursor {
    private final org.mongodb.MongoCursor delegate;

    MongoCursor(final org.mongodb.MongoCursor cursor) {
        delegate = cursor;
    }

}
