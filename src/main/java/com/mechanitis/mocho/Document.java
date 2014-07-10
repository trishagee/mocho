package com.mechanitis.mocho;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Document implements Map<String, Object> {
    private org.mongodb.Document delegate;
    
    public Document(final String key, final String value) {
        delegate = new org.mongodb.Document(key, value);
    }

    public Document append(final String key, final Object value) {
        delegate.append(key, value);
        return this;
    }

    public Document(final Map<String, Object> map) {
        delegate = new org.mongodb.Document(map);
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean containsKey(final Object key) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public boolean containsValue(final Object value) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Object get(final Object key) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Object put(final String key, final Object value) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Object remove(final Object key) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void putAll(final Map<? extends String, ?> m) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Collection<Object> values() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return delegate.entrySet();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    public org.mongodb.Document getDocument() {
        return delegate;
    }
}
