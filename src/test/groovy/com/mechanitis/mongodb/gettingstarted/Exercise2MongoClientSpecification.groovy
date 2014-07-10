package com.mechanitis.mongodb.gettingstarted

import com.mechanitis.mocho.MongoClient
import com.mechanitis.mocho.MongoCollection
import com.mechanitis.mocho.MongoDatabase
import spock.lang.Ignore
import spock.lang.Specification

public class Exercise2MongoClientSpecification extends Specification{
    def shouldGetADatabaseFromTheMongoClient() throws Exception {
        given:
        MongoClient mongoClient = new MongoClient();

        when:
        MongoDatabase database = mongoClient.getDatabase("TheDatabaseName");

        then:
        database != null;
    }

    def shouldGetACollectionFromTheDatabase() throws Exception {
        given:
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("TheDatabaseName");

        when:
        MongoCollection collection = database.getCollection("TheCollectionName");

        then:
        collection != null
    }

    @Ignore("not implemented")
    def shouldNotBeAbleToUseMongoClientAfterItHasBeenClosed() throws UnknownHostException {
        given:
        MongoClient mongoClient = new MongoClient();

        when:
        mongoClient.close();
        mongoClient.getDatabase("SomeDatabase").getCollection("coll").insert(["field": "value"]);
        
        then:
        thrown IllegalStateException
    }

}
