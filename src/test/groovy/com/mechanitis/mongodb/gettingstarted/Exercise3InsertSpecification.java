package com.mechanitis.mongodb.gettingstarted;

import com.mechanitis.mocho.Document;
import com.mechanitis.mocho.MongoClient;
import com.mechanitis.mocho.MongoClientURI;
import com.mechanitis.mocho.MongoCollection;
import com.mechanitis.mocho.MongoDatabase;
import com.mechanitis.mongodb.gettingstarted.person.Address;
import com.mechanitis.mongodb.gettingstarted.person.Person;
import com.mechanitis.mongodb.gettingstarted.person.PersonAdaptor;
import org.junit.Test;

import java.net.UnknownHostException;

import static com.mechanitis.mocho.test.util.JsonMatcher.jsonEqual;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Exercise3InsertSpecification {
    @Test
    public void shouldTurnAPersonIntoADocument() {
        //given:
        Person bob = new Person("bob", "Bob The Amazing", new Address("123 Fake St", "LondonTown", 1234567890), asList(27464, 747854));

        //when:
        Document bobAsDocument = PersonAdaptor.toDocument(bob);

        //then:
        String expectedDocument = "{" +
                                  " \"_id\" : \"bob\" ," +
                                  " \"name\" : \"Bob The Amazing\" ," +
                                  " \"address\" : {" +
                                    " \"street\" : \"123 Fake St\" ," +
                                    " \"city\" : \"LondonTown\" ," +
                                    " \"phone\" : 1234567890" +
                                  "} ," +
                                  " \"books\" : [ 27464 , 747854]" +
                                  "}";
        assertThat(bobAsDocument.toString(), jsonEqual(expectedDocument));
    }

    @Test
    public void shouldBeAbleToSaveAPerson() throws UnknownHostException {
        //given:
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase database = mongoClient.getDatabase("Examples");
        MongoCollection collection = database.getCollection("people");

        Person charlie = new Person("charlie", "Charles", new Address("74 That Place", "LondonTown", 1234567890), asList(1, 74));

        //when:
        collection.insert(PersonAdaptor.toDocument(charlie));

        //then:
        assertThat(collection.find().count(), is(1L));

        //cleanup:
        database.dropDatabase();
    }
}
