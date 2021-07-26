package com.java.ee.training.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/greeting/talk")
@Produces("text/plain")
@RequestScoped
public class Greeting {

    @Path("hello")
    @GET
    public String sayHello(@QueryParam("isim") final String name,
                           @QueryParam("soyisim") final String surname) {
        return "Hello " + name + " " + surname;
    }

    @Path("hello2/{xyz}/{abc}")
    @GET
    public String sayHello2(@PathParam("xyz") final String name,
                            @PathParam("abc") final String surname) {
        return "Hello 2 " + name + " " + surname;
    }

    @Path("hello3/{xyz}")
    @GET
    public String sayHello3(@PathParam("xyz") final String name,
                            @QueryParam("soyisim") final String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    @Inject
    private HttpServletRequest hsr;

    // Yanlış bunu kullanma
    @Path("hello4/{command}")
    @GET
    public String sayHello4(@PathParam("command") final String command,
                            @QueryParam("soyisim") final String surname) {
        switch (command) {
            case "add":
                String headerLoc = this.hsr.getHeader("xyz");
                break;
            case "help":
                String helpLoc = this.hsr.getParameter("help");
                break;

            default:
                break;
        }
        return "OK";
    }

    @Path("hello5")
    @GET
    public String sayHello5(@HeaderParam("isim") final String name,
                            @HeaderParam("soyisim") final String surname) {
        return "Hello 5 " + name + " " + surname;
    }

    @Path("hello6")
    @POST
    public String sayHello6(@FormParam("isim") final String name,
                            @FormParam("soyisim") final String surname) {
        return "Hello 6 " + name + " " + surname;
    }

    @Path("hello7")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String sayHello7(final Person person) {
        return "Hello 7 "
               + person.getName()
               + " "
               + person.getSurname()
               + " "
               + person.getHeight()
               + " "
               + person.getWeight();
    }

    @Path("hello8")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse sayHello8(final Person person) {
        return new PersonResponse().setFullName(person.getName() + " " + person.getSurname())
                                   .setResult("SUCCESS")
                                   .setErrorCause(0);
    }

    @Path("hello10")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello10(final Person person) {
        return Response.status(800)
                       .entity(new PersonResponse().setFullName(person.getName() + " " + person.getSurname())
                                                   .setResult("SUCCESS")
                                                   .setErrorCause(0))
                       .header("test",
                               "testme")
                       .build();
    }

    @Path("hello9/{weight}")
    @POST
    public String sayHello9(@BeanParam final Person person) {
        return "Hello 9 "
               + person.getName()
               + " "
               + person.getSurname()
               + " "
               + person.getHeight()
               + " "
               + person.getWeight();
    }

}
