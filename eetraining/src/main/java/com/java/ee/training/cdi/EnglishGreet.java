package com.java.ee.training.cdi;

import java.io.Serializable;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Named("eng")
@Alternative
public class EnglishGreet implements IGreet, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1614986693397323514L;

    @Override
    public String hello(final String nameParam) {
        return "Hello " + nameParam;
    }

    @Override
    public String goodbye(final String nameParam) {
        return "Goodbye " + nameParam;
    }

}
