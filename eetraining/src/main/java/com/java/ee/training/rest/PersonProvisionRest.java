package com.java.ee.training.rest;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/api/v1/person/provision")
public class PersonProvisionRest {

    @Path("/add")
    @POST
    @Produces("text/plain")
    public String add(@Valid final Person person) {
        if ((person.getName() == null)
            || person.getName()
                     .isEmpty()) {
            throw new IllegalArgumentException();
        }
        return "SUCCESS";
    }

}
