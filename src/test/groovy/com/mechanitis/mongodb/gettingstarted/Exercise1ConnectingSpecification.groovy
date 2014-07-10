package com.mechanitis.mongodb.gettingstarted

import com.mechanitis.mocho.MongoClient
import spock.lang.Specification

class Exercise1ConnectingSpecification extends Specification {
    def 'should create a new mongo client connected to localhost'() throws Exception {
        when:
        MongoClient mongoClient = new MongoClient()

        then:
        mongoClient != null
    }

    def 'should be able to connected via URI'() {
        
    }

}
