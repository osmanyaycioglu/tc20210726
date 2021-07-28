package com.java.ee.training.person.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.java.ee.training.person.models.PersonDTO;

@LocalBean
@Singleton
public class PersonStorage {

    private final Map<String, PersonDTO> personMap = new ConcurrentHashMap<>();

    public void addPerson(final PersonDTO person) {
        this.personMap.put(person.getUsername(),
                           person);
    }

    public void removePerson(final String username) {
        this.personMap.remove(username);
    }


    public PersonDTO getPerson(final String username) {
        return this.personMap.get(username);
    }

    public List<PersonDTO> getAll() {
        return new ArrayList<>(this.personMap.values());
    }

}
