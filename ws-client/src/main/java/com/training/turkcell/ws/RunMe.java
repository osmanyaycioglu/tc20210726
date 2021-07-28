package com.training.turkcell.ws;

import java.security.SecureRandom;
import java.util.Random;

import com.person.Person;
import com.person.PersonProvisionWS;
import com.person.PersonProvisionWSService;

public class RunMe {

    public static void main(final String[] args) {
        PersonProvisionWSService wsService = new PersonProvisionWSService();
        PersonProvisionWS personPortLoc = wsService.getPersonProvisionWSPort();
        Random randomLoc = new SecureRandom();
        Person personLoc = new Person();
        personLoc.setUsername("osman" + randomLoc.nextLong());
        personLoc.setName("osman" + randomLoc.nextLong());
        personLoc.setSurname("yaycıoğlu");
        personLoc.setHeight(200);
        personLoc.setWeight(95);
        String resultLoc = personPortLoc.add(personLoc);
        System.out.println(resultLoc);
    }
}
