package com.mechanitis.mongodb.gettingstarted

import spock.lang.Specification

public class Exercise3InsertSpecification extends Specification {
//    public void shouldTurnAPersonIntoADocument() {
//        // Given
//        Person bob = new Person("bob", "Bob The Amazing", new Address("123 Fake St", "LondonTown", 1234567890), asList(27464, 747854));
//
//        // When
//        Document bobAsDocument = PersonAdaptor.toDocument(bob);
//
//        // Then
//        String expectedDocument = "{" +
//                                  " \"_id\" : \"bob\" ," +
//                                  " \"name\" : \"Bob The Amazing\" ," +
//                                  " \"address\" : {" +
//                                    " \"street\" : \"123 Fake St\" ," +
//                                    " \"city\" : \"LondonTown\" ," +
//                                    " \"phone\" : 1234567890" +
//                                  "} ," +
//                                  " \"books\" : [ 27464 , 747854]" +
//                                  "}";
//        assertThat(bobAsDocument.toString(), is(expectedDocument));
//    }
//
//    public void shouldBeAbleToSaveAPerson() throws UnknownHostException {
//        // Given
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
//        MongoDatabase database = mongoClient.getDatabase("Examples");
//        MongoCollection collection = database.getCollection("people");
//
//        Person charlie = new Person("charlie", "Charles", new Address("74 That Place", "LondonTown", 1234567890), asList(1, 74));
//
//        // When
//        // TODO: insert Charlie into the collection
//
//        // Then
//        assertThat(collection.find().count(), is(1));
//
//        // Clean up
//        database.dropDatabase();
//    }
}
