package com.training.rest.client.restclient;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ComLineRun1 implements CommandLineRunner {

    @Autowired
    private IPersonManagementClient pmc;

    @Override
    public void run(final String... argsParam) throws Exception {
        Random randomLoc = new SecureRandom();
        Person personLoc = new Person();
        personLoc.setUsername("osman" + randomLoc.nextLong());
        personLoc.setName("osman" + randomLoc.nextLong());
        personLoc.setSurname("yaycıoğlu");
        personLoc.setHeight(200);
        personLoc.setWeight(95);
        String addLoc = this.pmc.add(personLoc);
        System.out.println("Feign client result : " + addLoc);
        List<Person> getallLoc = this.pmc.getall();
        for (Person person2Loc : getallLoc) {
            System.out.println(person2Loc);
        }
    }

}
