package com.mechanitis.mongodb.gettingstarted.person;

import com.mechanitis.mocho.Document;

/**
 * This Adaptor allows us to separate our domain object, Person, from our library-specific classes, in this case the MongoDB-specific
 * DBObject.
 */
public final class PersonAdaptor {
    public static final Document toDocument(Person person) {
        return new Document("_id", person.getId())
               .append("name", person.getName())
               .append("address", toDocument(person.getAddress()).getDocument())
               .append("books", person.getBookIds());
    }

    private static Document toDocument(Address address) {
        return new Document("street", address.getStreet())
               .append("city", address.getTown())
               .append("phone", address.getPhone());
    }
}
