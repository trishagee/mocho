package com.mechanitis.mongodb.gettingstarted;

import com.mechanitis.mocho.Document;
import com.mechanitis.mocho.MongoClient;
import com.mechanitis.mocho.MongoClientURI;
import com.mechanitis.mocho.MongoCollection;
import com.mechanitis.mocho.MongoDatabase;
import com.mechanitis.mongodb.gettingstarted.person.Address;
import com.mechanitis.mongodb.gettingstarted.person.Person;
import com.mechanitis.mongodb.gettingstarted.person.PersonAdaptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@SuppressWarnings("unchecked")
public class Exercise4RetrieveTest {
    private MongoDatabase database;
    private MongoCollection collection;

    @Before
    public void setUp() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDatabase("Examples");
        collection = database.getCollection("people");
    }

    @Test
    public void shouldRetrieveBobFromTheDatabaseWhenHeIsTheOnlyOneInThere() {
        // Given
        Person bob = new Person("bob", "Bob The Amazing", new Address("123 Fake St", "LondonTown", 1234567890), asList(27464, 747854));
        collection.insert(PersonAdaptor.toDocument(bob));

        // When
        Optional<Document> result = collection.stream().findAny();

        // Then
        assertThat(result.isPresent(), is(true));
        assertThat(result.get().getString("_id"), is("bob"));
    }

    @Test
    public void shouldRetrieveEverythingFromTheDatabase() {
        // Given
        Person charlie = new Person("charlie", "Charles", new Address("74 That Place", "LondonTown", 1234567890), asList(1, 74));
        collection.insert(PersonAdaptor.toDocument(charlie));

        Person bob = new Person("bob", "Bob The Amazing", new Address("123 Fake St", "LondonTown", 1234567890), asList(27464, 747854));
        collection.insert(PersonAdaptor.toDocument(bob));

        // When
        Object[] results = collection.stream().sorted((o1, o2) -> (o1.getString("_id")).compareTo(o2.getString("_id")))
                                     .toArray();

        // Then
        assertThat(results.length, is(2));
        
        // they should come back in the same order they were put in
        assertThat((String) ((Document)results[0]).get("_id"), is("bob"));
        assertThat((String) ((Document)results[1]).get("_id"), is("charlie"));
    }

    @Test
    public void shouldSearchForAndReturnOnlyBobFromTheDatabaseWhenMorePeopleExist() {
        // Given
        Person charlie = new Person("charlie", "Charles", new Address("74 That Place", "LondonTown", 1234567890), asList(1, 74));
        collection.insert(PersonAdaptor.toDocument(charlie));

        Person bob = new Person("bob", "Bob The Amazing", new Address("123 Fake St", "LondonTown", 1234567890), asList(27464, 747854));
        collection.insert(PersonAdaptor.toDocument(bob));

        // When
        Stream<Document> documentStream = collection.stream().filter(document -> document.get("_id").equals("bob"));

        // Then
        assertThat(documentStream.count(), is(1L));
        assertThat((String) documentStream.findAny().get().get("name"), is("Bob The Amazing"));
    }


    @After
    public void tearDown() {
        database.dropDatabase();
    }
}
