package com.mechanitis.mongodb.gettingstarted;

import com.mechanitis.mocho.Document;
import com.mechanitis.mocho.MongoClient;
import com.mechanitis.mocho.MongoCollection;
import com.mechanitis.mocho.MongoDatabase;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class Exercise2MongoClientSpecification {
    @Test
    public void shouldGetADatabaseFromTheMongoClient() throws Exception {
        //given:
        MongoClient mongoClient = new MongoClient();

        //when:
        MongoDatabase database = mongoClient.getDatabase("TheDatabaseName");

        //then:
        assertThat(database, is(notNullValue()));
    }

    @Test
    public void shouldGetACollectionFromTheDatabase() throws Exception {
        //given:
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("TheDatabaseName");

        //when:
        MongoCollection collection = database.getCollection("TheCollectionName");

        //then:
        assertThat(collection, is(notNullValue()));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotBeAbleToUseMongoClientAfterItHasBeenClosed() throws UnknownHostException {
        //given:
        MongoClient mongoClient = new MongoClient();

        //when:
        mongoClient.close();
        mongoClient.getDatabase("SomeDatabase").getCollection("coll").insert(new Document("field", "value"));
    }

}
