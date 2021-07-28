package com.java.ee.training.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.java.ee.training.rest.Person;

@WebService(targetNamespace = "http://turkcell.com/training")
public class PersonTestWs {

    @WebMethod(operationName = "addMe")
    public String add(@WebParam(name = "person") final Person person) {
        if ((person.getName() == null)
            || person.getName()
                     .isEmpty()) {
            throw new IllegalArgumentException();
        }
        return "SUCCESS";
    }

}
