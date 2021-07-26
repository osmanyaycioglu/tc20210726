package com.java.ee.training.rest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/api/v1/person/provision")
@WebService(targetNamespace = "http://turkcell.com/training")
public class PersonProvisionRest {

    @Path("/add")
    @GET
    @Produces("text/plain")
    @WebMethod(operationName = "addMe")
    public String add(@WebParam(name = "person") final Person person) {
        return "SUCCESS";
    }

}
