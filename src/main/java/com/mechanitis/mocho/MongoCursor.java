package com.mechanitis.mocho;

import com.mongodb.DBCursor;

public class MongoCursor {
    private final DBCursor delegate;

    MongoCursor(final DBCursor dbCursor) {
        delegate = dbCursor;
    }

    public int count() {
        return delegate.count();
    }
}
