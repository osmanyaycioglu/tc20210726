package com.java.ee.training.person.mappings;

import com.java.ee.training.person.models.PersonDTO;
import com.java.ee.training.person.models.PersonDetail;
import com.java.ee.training.rest.Person;

public class PersonMapping {

    public static PersonDTO personToDTO(final Person person) {
        PersonDTO personDTOLoc = new PersonDTO();
        personDTOLoc.setPersonId(person.getPersonId());
        personDTOLoc.setUsername(person.getUsername());
        personDTOLoc.setName(person.getName());
        personDTOLoc.setSurname(person.getSurname());
        personDTOLoc.setWeight(person.getWeight());
        personDTOLoc.setHeight(person.getHeight());
        PersonDetail detailLoc = new PersonDetail();
        detailLoc.setGender(person.getGender());
        detailLoc.setNote(person.getNote());
        personDTOLoc.setPersonDetail(detailLoc);
        personDTOLoc.setAddress(person.getAddress());
        return personDTOLoc;
    }


    public static Person DTOToPerson(final PersonDTO personLoc) {
        Person person = new Person();
        person.setUsername(personLoc.getUsername());
        person.setName(personLoc.getName());
        person.setSurname(personLoc.getSurname());
        person.setWeight(personLoc.getWeight());
        person.setHeight(personLoc.getHeight());
        person.setGender(personLoc.getPersonDetail()
                                  .getGender());
        person.setNote(personLoc.getPersonDetail()
                                .getNote());
        person.setAddress(personLoc.getAddress());
        person.setPersonId(personLoc.getPersonId());
        return person;
    }

}
