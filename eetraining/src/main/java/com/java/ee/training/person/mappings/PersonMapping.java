package com.java.ee.training.person.mappings;

import com.java.ee.training.person.models.PersonDTO;
import com.java.ee.training.rest.Person;

public class PersonMapping {

    public static PersonDTO personToDTO(final Person person) {
        PersonDTO personDTOLoc = new PersonDTO();
        personDTOLoc.setUsername(person.getUsername());
        personDTOLoc.setName(person.getName());
        personDTOLoc.setSurname(person.getSurname());
        personDTOLoc.setWeight(person.getWeight());
        personDTOLoc.setHeight(person.getHeight());
        return personDTOLoc;
    }


    public static Person DTOToPerson(final PersonDTO personLoc) {
        Person person = new Person();
        person.setUsername(personLoc.getUsername());
        person.setName(personLoc.getName());
        person.setSurname(personLoc.getSurname());
        person.setWeight(personLoc.getWeight());
        person.setHeight(personLoc.getHeight());
        return person;
    }

}
