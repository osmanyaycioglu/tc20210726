package com.java.ee.training.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class Person {

    @QueryParam("name")
    @NotEmpty
    @Size(min = 2, max = 25, message = "Name 2 ile 20 arasında olmalı")
    private String  name;
    @QueryParam("surname")
    @NotEmpty
    @Size(min = 3, max = 30, message = "Surname 3 ile 30 arasında olmalı")
    private String  surname;
    @Max(300)
    @Min(10)
    @PathParam("weight")
    private Integer weight;
    @Max(300)
    @Min(50)
    @HeaderParam("height")
    private Integer height;

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


}
