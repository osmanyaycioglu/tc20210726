package com.training.turkcell.ws;

import java.util.List;

import com.person.Person;
import com.person.PersonProvisionWS;
import com.person.PersonProvisionWSService;

public class GetAll {

    public static void main(final String[] args) {
        PersonProvisionWSService wsService = new PersonProvisionWSService();
        PersonProvisionWS personPortLoc = wsService.getPersonProvisionWSPort();
        List<Person> getallLoc = personPortLoc.getall();
        System.out.println(getallLoc);

    }
}
