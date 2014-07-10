package com.mechanitis.mongodb.gettingstarted;

import com.mechanitis.mocho.MongoClient;
import com.mechanitis.mocho.MongoClientURI;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class Exercise1ConnectingTest {
    @Test
    public void shouldCreateANewMongoClientConnectedToLocalhost() throws Exception {
        //when: 
        MongoClient mongoClient = new MongoClient();

        //then:
        assertThat(mongoClient, is(notNullValue()));
    }

    @Test
    public void shouldBeAbleToConnectViaURI() throws Exception {
        //when:
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

        //then:
        assertThat(mongoClient, is(notNullValue()));
    }

}
