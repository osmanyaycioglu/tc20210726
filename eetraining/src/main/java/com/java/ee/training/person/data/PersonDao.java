package com.java.ee.training.person.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.java.ee.training.person.models.PersonDTO;

@LocalBean
@Stateless
public class PersonDao {

    @PersistenceContext(unitName = "eetraining")
    private EntityManager em;

    //    @PersistenceUnit(unitName = "eetraining")
    //    private EntityManagerFactory emf;

    public void addPersonPureJava(final PersonDTO person) {
        this.em.getTransaction()
               .begin();
        try {
            this.em.persist(person); // Managed
            person.setUsername("asghjd");
            this.em.getTransaction()
                   .commit();
        } catch (Exception eLoc) {
            this.em.getTransaction()
                   .rollback();
        }
    }

    public void addPerson(final PersonDTO person) {
        this.em.persist(person); // Managed
        person.setUsername("asghjd");
    }

    public void updatePerson(final PersonDTO person) {
        if (!this.em.contains(person)) {
            PersonDTO mergedPersonLoc = this.em.merge(person);
        }
    }

    public void updatePerson2(final PersonDTO person) {
        if (!this.em.contains(person)) {
            PersonDTO mergedPersonLoc = this.em.find(PersonDTO.class,
                                                     person.getPersonId());
            mergedPersonLoc.setUsername("xyz");
        } else {
            this.em.refresh(person);
            person.setUsername("xyz");
        }
    }

    public void examplePerson(final PersonDTO person) {
        person.setUsername("asghjd");
        person.setName("example");
    }

    public void removePerson(final Long personId) {
        PersonDTO findLoc = this.em.find(PersonDTO.class,
                                         personId);
        this.em.remove(findLoc);
    }


    public List<PersonDTO> getPerson(final String username) {
        TypedQuery<PersonDTO> createQueryLoc = this.em.createQuery("select p from PersonDTO p where p.username=?1",
                                                                   PersonDTO.class);
        createQueryLoc.setParameter(1,
                                    username);
        return createQueryLoc.getResultList();
    }

    public List<PersonDTO> getPersonNative(final String username) {
        Query createQueryLoc = this.em.createNativeQuery("select * from person where username=?1",
                                                         PersonDTO.class);
        createQueryLoc.setParameter(1,
                                    username);
        return createQueryLoc.getResultList();
    }

    public PersonDTO getPerson(final Long personId) {
        return this.em.find(PersonDTO.class,
                            personId);
    }

    public List<PersonDTO> getAll() {
        TypedQuery<PersonDTO> createQueryLoc = this.em.createQuery("select p from PersonDTO p",
                                                                   PersonDTO.class);
        return createQueryLoc.getResultList();
    }


}
