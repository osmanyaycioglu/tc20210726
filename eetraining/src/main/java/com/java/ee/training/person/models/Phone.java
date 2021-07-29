package com.java.ee.training.person.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@TableGenerator(pkColumnName = "generator",
                pkColumnValue = "phoneIdGen",
                name = "phoneIdGen",
                table = "pkgen",
                initialValue = 1,
                allocationSize = 100)
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "phoneIdGen")
    private Long      phoneId;
    private String    name;
    private String    destination;

    @ManyToOne
    @XmlTransient
    private PersonDTO person;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(final String destinationParam) {
        this.destination = destinationParam;
    }

    public Long getPhoneId() {
        return this.phoneId;
    }

    public void setPhoneId(final Long phoneIdParam) {
        this.phoneId = phoneIdParam;
    }

    public PersonDTO getPerson() {
        return this.person;
    }

    public void setPerson(final PersonDTO personParam) {
        this.person = personParam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.destination,
                            this.name,
                            this.person,
                            this.phoneId);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Phone other = (Phone) obj;
        return Objects.equals(this.destination,
                              other.destination)
               && Objects.equals(this.name,
                                 other.name)
               && Objects.equals(this.person,
                                 other.person)
               && Objects.equals(this.phoneId,
                                 other.phoneId);
    }


}
