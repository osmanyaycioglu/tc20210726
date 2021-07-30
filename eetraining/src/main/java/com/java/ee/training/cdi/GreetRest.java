package com.java.ee.training.cdi;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.java.ee.training.cdi.interceptor.Caller;
import com.java.ee.training.cdi.interceptor.Tutucu;

@Path("/gr")
@ApplicationScoped
public class GreetRest implements Serializable {

    private int               counter          = 0;

    private static final long serialVersionUID = -7393143774365992942L;
    @Inject
    // @Alternative
    @Named("dyn")
    private IGreet            greet;

    //    @Inject
    //    @Named("eng")
    //    private IGreet greet2;
    //
    //    @Inject
    //    @Named("esp")
    //    private IGreet greet3;

    @Inject
    private Caller caller;

    @Path("/call")
    @GET
    @Tutucu
    public String call(@QueryParam("name") final String name) {
        return this.caller.callOther(name);
    }


    @Path("/hello")
    @GET
    public String hello(@QueryParam("name") final String name) {
        this.counter++;
        return "Counter : " + this.counter + " " + this.greet.hello(name);
    }

    @Path("/goodbye")
    @GET
    public String goodbye(@QueryParam("name") final String name) {
        return this.greet.goodbye(name);
    }

}
