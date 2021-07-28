package com.java.ee.training.person.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.Valid;

import com.java.ee.training.person.mappings.PersonMapping;
import com.java.ee.training.person.models.PersonDTO;
import com.java.ee.training.person.services.PersonManagement;
import com.java.ee.training.rest.Person;

@WebService
public class PersonProvisionWS {

    @EJB
    private PersonManagement pm;

    public String add(@Valid @WebParam(name = "person") final Person person) {
        PersonDTO personDTOLoc = PersonMapping.personToDTO(person);
        this.pm.addPerson(personDTOLoc);
        return "SUCCESS";
    }

    public Person get(@WebParam(name = "username") final String username) {
        PersonDTO personLoc = this.pm.getPerson(username);
        if (personLoc == null) {
            throw new IllegalArgumentException("Bu isimli user yok : " + username);
        }
        Person person = PersonMapping.DTOToPerson(personLoc);
        return person;
    }

    public List<Person> getall() {
        List<PersonDTO> personsLoc = this.pm.getAll();
        List<Person> personList = new ArrayList<>();
        for (PersonDTO personDTOLoc : personsLoc) {
            Person personLoc = PersonMapping.DTOToPerson(personDTOLoc);
            personList.add(personLoc);
        }
        return personList;
    }
}
