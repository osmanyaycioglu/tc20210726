package com.java.ee.training.rest;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.java.ee.training.person.models.Address;
import com.java.ee.training.person.models.EGender;

@XmlRootElement
public class Person {


    private Long            personId;
    @NotEmpty
    @Size(min = 5, max = 25, message = "Username 5 ile 20 arasında olmalı")
    private String          username;

    @QueryParam("name")
    @NotEmpty
    @Size(min = 2, max = 25, message = "Name 2 ile 20 arasında olmalı")
    private String          name;
    @QueryParam("surname")
    @NotEmpty
    @Size(min = 3, max = 30, message = "Surname 3 ile 30 arasında olmalı")
    private String          surname;
    @Max(300)
    @Min(10)
    @PathParam("weight")
    private Integer         weight;
    @Max(300)
    @Min(50)
    @HeaderParam("height")
    private Integer         height;
    private EGender         gender;
    private String          note;

    private Address         address;

    private List<Telephone> phones;

    public EGender getGender() {
        return this.gender;
    }


    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }


    public String getNote() {
        return this.note;
    }


    public void setNote(final String noteParam) {
        this.note = noteParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }


    public Address getAddress() {
        return this.address;
    }


    public void setAddress(final Address addressParam) {
        this.address = addressParam;
    }


    public Long getPersonId() {
        return this.personId;
    }


    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }


    public List<Telephone> getPhones() {
        return phones;
    }


    public void setPhones(List<Telephone> phonesParam) {
        phones = phonesParam;
    }


}
