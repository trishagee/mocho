package com.mechanitis.mocho;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class DocumentStream implements Stream<Document> {
    private final org.mongodb.MongoCollection<org.mongodb.Document> delegate;
    private Predicate<? super Document> predicate;
    private Comparator<? super Document> comparator;

    protected DocumentStream(final org.mongodb.MongoCollection<org.mongodb.Document> collection) {
        this.delegate = collection;
    }

    @Override
    public Stream<Document> filter(final Predicate<? super Document> predicate) {
        this.predicate = predicate;
        return this;
    }

    @Override
    public <R> Stream<R> map(final Function<? super Document, ? extends R> mapper) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public IntStream mapToInt(final ToIntFunction<? super Document> mapper) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public LongStream mapToLong(final ToLongFunction<? super Document> mapper) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public DoubleStream mapToDouble(final ToDoubleFunction<? super Document> mapper) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public <R> Stream<R> flatMap(final Function<? super Document, ? extends Stream<? extends R>> mapper) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public IntStream flatMapToInt(final Function<? super Document, ? extends IntStream> mapper) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public LongStream flatMapToLong(final Function<? super Document, ? extends LongStream> mapper) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public DoubleStream flatMapToDouble(final Function<? super Document, ? extends DoubleStream> mapper) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Stream<Document> distinct() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Stream<Document> sorted() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Stream<Document> sorted(final Comparator<? super Document> comparator) {
        this.comparator = comparator;
        return this;
    }

    @Override
    public Stream<Document> peek(final Consumer<? super Document> action) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Stream<Document> limit(final long maxSize) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Stream<Document> skip(final long n) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void forEach(final Consumer<? super Document> action) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void forEachOrdered(final Consumer<? super Document> action) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Object[] toArray() {
        return getResults().toArray();
    }

    @Override
    public <A> A[] toArray(final IntFunction<A[]> generator) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Document reduce(final Document identity, final BinaryOperator<Document> accumulator) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Optional<Document> reduce(final BinaryOperator<Document> accumulator) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public <U> U reduce(final U identity, final BiFunction<U, ? super Document, U> accumulator, final BinaryOperator<U> combiner) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public <R> R collect(final Supplier<R> supplier, final BiConsumer<R, ? super Document> accumulator, final BiConsumer<R, R> combiner) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public <R, A> R collect(final Collector<? super Document, A, R> collector) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Optional<Document> min(final Comparator<? super Document> comparator) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Optional<Document> max(final Comparator<? super Document> comparator) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public long count() {
        List<Document> results = getResults();
        return results.size();
    }

    @Override
    public boolean anyMatch(final Predicate<? super Document> predicate) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public boolean allMatch(final Predicate<? super Document> predicate) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public boolean noneMatch(final Predicate<? super Document> predicate) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Optional<Document> findFirst() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Optional<Document> findAny() {
        List<Document> results = getResults();
        return results.size() > 0 ? Optional.<Document>ofNullable(new Document(results.get(0))) : Optional.empty();
    }

    @Override
    public Iterator<Document> iterator() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Spliterator<Document> spliterator() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public boolean isParallel() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Stream<Document> sequential() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Stream<Document> parallel() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Stream<Document> unordered() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Stream<Document> onClose(final Runnable closeHandler) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    private List<Document> getResults() {
        org.mongodb.MongoView<org.mongodb.Document> documents = delegate.find();
        List<Document> results = new ArrayList<>();
        for (org.mongodb.Document document : documents) {
            Document t = new Document(document);
            if (predicate == null || predicate.test(t)) {
                results.add(t);
            }
        }
        if (comparator != null) {
            results.sort(comparator);
        }
        return results;
    }
}
