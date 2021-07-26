package com.java.ee.training.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/v1/greetingex/talk/hello")
public class GreetingEx {

    @GET
    public void sayHello(final String name,
                         final String surname) {

    }

}
