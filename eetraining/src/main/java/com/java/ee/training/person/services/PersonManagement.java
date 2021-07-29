package com.java.ee.training.person.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.java.ee.training.person.data.PersonDao;
import com.java.ee.training.person.models.PersonDTO;

@LocalBean
@Singleton
public class PersonManagement {

    @EJB
    private PersonDao ps;

    public void addPerson(final PersonDTO person) {
        this.ps.addPerson(person);
    }

    public void removePerson(final Long personId) {
        this.ps.removePerson(personId);
    }


    public PersonDTO getPerson(final Long personId) {
        return this.ps.getPerson(personId);
    }

    public List<PersonDTO> getAll() {
        return this.ps.getAll();
    }

    public void updatePerson(final PersonDTO personDTOParam) {
        this.ps.updatePerson(personDTOParam);
    }


}
