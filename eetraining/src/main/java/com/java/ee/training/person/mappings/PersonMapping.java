package com.java.ee.training.person.mappings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.java.ee.training.person.models.Address;
import com.java.ee.training.person.models.PersonDTO;
import com.java.ee.training.person.models.PersonDetail;
import com.java.ee.training.person.models.Phone;
import com.java.ee.training.rest.Person;
import com.java.ee.training.rest.Telephone;

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

        Address addressLoc = person.getAddress();
        addressLoc.setPerson(personDTOLoc);
        personDTOLoc.setAddress(person.getAddress());

        Set<Phone> phoneSetLoc = new HashSet<>();
        List<Telephone> phonesLoc = person.getPhones();
        for (Telephone phoneLoc : phonesLoc) {
            Phone internalPhone = new Phone();
            internalPhone.setName(phoneLoc.getName());
            internalPhone.setDestination(phoneLoc.getDestination());
            internalPhone.setPerson(personDTOLoc);
            phoneSetLoc.add(internalPhone);
        }
        personDTOLoc.setPhones(phoneSetLoc);

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
        Set<Phone> phonesLoc = personLoc.getPhones();
        List<Telephone> telephonesLoc = new ArrayList<>();
        for (Phone phoneLoc : phonesLoc) {
            Telephone telephoneLoc = new Telephone();
            telephoneLoc.setDestination(phoneLoc.getDestination());
            telephoneLoc.setName(phoneLoc.getName());
            telephonesLoc.add(telephoneLoc);
        }
        person.setPhones(telephonesLoc);
        return person;
    }

}
