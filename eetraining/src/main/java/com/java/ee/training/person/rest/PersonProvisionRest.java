package com.java.ee.training.person.rest;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
        PersonDTO personDTOLoc = new PersonDTO();
        personDTOLoc.setUsername(person.getUsername());
        personDTOLoc.setName(person.getName());
        personDTOLoc.setSurname(person.getSurname());
        personDTOLoc.setWeight(person.getWeight());
        personDTOLoc.setHeight(person.getHeight());
        this.pm.addPerson(personDTOLoc);
        return "SUCCESS";
    }

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person add(@QueryParam("un") final String username) {
        PersonDTO personLoc = this.pm.getPerson(username);
        if (personLoc == null) {
            throw new IllegalArgumentException("Bu isimli user yok : " + username);
        }
        Person person = new Person();
        person.setUsername(personLoc.getUsername());
        person.setName(personLoc.getName());
        person.setSurname(personLoc.getSurname());
        person.setWeight(personLoc.getWeight());
        person.setHeight(personLoc.getHeight());
        return person;
    }

}
