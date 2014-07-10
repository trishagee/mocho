package com.mechanitis.mocho;

import java.net.UnknownHostException;

public class MongoClient {
    private com.mongodb.MongoClient delegate;

    public MongoClient() throws UnknownHostException {
        this.delegate = new com.mongodb.MongoClient();
    }
    
    public MongoClient(final MongoClientURI uri) throws UnknownHostException {
        this.delegate = new com.mongodb.MongoClient(uri.getMongoURI());
    }

    public MongoDatabase getDatabase(final String databaseName) {
        return new MongoDatabase(delegate.getDB(databaseName));
    }

    public void close() {
        delegate.close();
    }
    //    MongoDatabase getDatabase(String databaseName);
//
//    /**
//     * @param databaseName the name of the database to retrieve
//     * @return a MongoDatabase representing the specified database
//     */
//    MongoDatabase getDatabase(String databaseName, MongoDatabaseOptions options);
//
//    /**
//     * Close the client, releasing all resources.  Implementations of this method should be idempotent.
//     */
//    void close();
//
//    /**
//     * Get the options for this client.
//     *
//     * @return the options
//     */
//    MongoClientOptions getOptions();
//
//    /**
//     * @return the ClientAdministration that provides admin methods that can be performed
//     */
//    ClientAdministration tools();
//
}
