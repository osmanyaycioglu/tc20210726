package com.java.ee.training.person.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.java.ee.training.person.mappings.PersonMapping;
import com.java.ee.training.person.models.PersonDTO;
import com.java.ee.training.person.services.PersonManagement;
import com.java.ee.training.rest.Person;

@Path("/api/v1/person/provision")
public class PersonProvisionRest {

    @EJB
    private PersonManagement pm;

    @Path("/add")
    @POST
    @Produces("text/plain")
    public String add(@Valid final Person person) {
        PersonDTO personDTOLoc = PersonMapping.personToDTO(person);
        this.pm.addPerson(personDTOLoc);
        return "SUCCESS";
    }

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person get(@QueryParam("un") final String username) {
        PersonDTO personLoc = this.pm.getPerson(username);
        if (personLoc == null) {
            throw new IllegalArgumentException("Bu isimli user yok : " + username);
        }
        Person person = PersonMapping.DTOToPerson(personLoc);
        return person;
    }

    @Path("/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
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
