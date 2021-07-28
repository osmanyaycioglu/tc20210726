package com.training.turkcell.ws;

import java.security.SecureRandom;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.person.Person;

public class JaxBRun {

    public static void main(final String[] args) throws Exception {
        JAXBContext newInstanceLoc = JAXBContext.newInstance(Person.class);
        Marshaller createMarshallerLoc = newInstanceLoc.createMarshaller();
        Random randomLoc = new SecureRandom();
        Person personLoc = new Person();
        personLoc.setUsername("osman" + randomLoc.nextLong());
        personLoc.setName("osman" + randomLoc.nextLong());
        personLoc.setSurname("yaycıoğlu");
        personLoc.setHeight(200);
        personLoc.setWeight(95);

        createMarshallerLoc.marshal(personLoc,
                                    System.out);
    }
}
