package com.java.ee.training.ejb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/api/v1/calc")
//@RequestScoped
@SessionScoped
//@ApplicationScoped
public class CalculatorRest implements Serializable {

    private static final long   serialVersionUID = 3888443026458773685L;

    @EJB
    private Calculator          calculator;

    @EJB
    private CalculatorStateless calcStateless;

    @EJB
    private CalculatorSingleton calcSingleton;

    @Path("/stateful/add")
    @GET
    @Produces("text/plain")
    public String add(@QueryParam("i1") final Integer i1,
                      @QueryParam("i2") final Integer i2) {
        int addLoc = this.calculator.add(i1,
                                         i2);
        return "Sonuç : " + addLoc + " total : " + this.calculator.getTotal();
    }

    @Path("/stateful/subs")
    @GET
    @Produces("text/plain")
    public String subs(@QueryParam("i1") final Integer i1,
                       @QueryParam("i2") final Integer i2) {
        int addLoc = this.calculator.subs(i1,
                                          i2);
        return "Sonuç : " + addLoc + " total : " + this.calculator.getTotal();
    }

    @Path("/stateless/add")
    @GET
    @Produces("text/plain")
    public String add2(@QueryParam("i1") final Integer i1,
                       @QueryParam("i2") final Integer i2) {
        int addLoc = this.calcStateless.add(i1,
                                            i2);
        return "Sonuç : " + addLoc + " total : " + this.calcStateless.getTotal();
    }

    @Path("/stateless/subs")
    @GET
    @Produces("text/plain")
    public String subs2(@QueryParam("i1") final Integer i1,
                        @QueryParam("i2") final Integer i2) {
        int addLoc = this.calcStateless.subs(i1,
                                             i2);
        return "Sonuç : " + addLoc + " total : " + this.calcStateless.getTotal();
    }

    @Path("/singleton/add")
    @GET
    @Produces("text/plain")
    public String add3(@QueryParam("i1") final Integer i1,
                       @QueryParam("i2") final Integer i2) {
        int addLoc = this.calcSingleton.add(i1,
                                            i2);
        return "Sonuç : " + addLoc + " total : " + this.calcSingleton.getTotal();
    }

    @Path("/singleton/subs")
    @GET
    @Produces("text/plain")
    public String subs3(@QueryParam("i1") final Integer i1,
                        @QueryParam("i2") final Integer i2) {
        int addLoc = this.calcSingleton.subs(i1,
                                             i2);
        return "Sonuç : " + addLoc + " total : " + this.calcSingleton.getTotal();
    }

}
