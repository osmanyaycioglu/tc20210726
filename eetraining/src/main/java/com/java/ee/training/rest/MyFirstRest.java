package com.java.ee.training.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/first")
//@Produces("text/plain")
public class MyFirstRest {

    @Path("/hello")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello world";
    }

    @Path("/hello")
    @POST
    @Produces("text/plain")
    public String hello2() {
        return "Hello world POST";
    }

    @Path("/hello")
    @PATCH
    @Produces("text/plain")
    public String hello3() {
        return "Hello world PATCH";
    }

    @Path("/hello")
    @PUT
    @Produces("text/plain")
    public String hello4() {
        return "Hello world PUT";
    }

    @Path("/hello")
    @DELETE
    @Produces("text/plain")
    public String hello5() {
        return "Hello world DELETE";
    }

}
