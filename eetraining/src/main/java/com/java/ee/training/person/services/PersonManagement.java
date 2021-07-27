package com.java.ee.training.person.services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.java.ee.training.person.data.PersonStorage;
import com.java.ee.training.person.models.PersonDTO;

@LocalBean
@Singleton
public class PersonManagement {

    @EJB
    private PersonStorage ps;

    public void addPerson(final PersonDTO person) {
        this.ps.addPerson(person);
    }

    public void removePerson(final String username) {
        this.ps.removePerson(username);
    }


    public PersonDTO getPerson(final String username) {
        return this.ps.getPerson(username);
    }


}
