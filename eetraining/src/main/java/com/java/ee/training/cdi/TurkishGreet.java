package com.java.ee.training.cdi;

import java.io.Serializable;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Named("tr")
@Alternative
public class TurkishGreet implements IGreet, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7598060029432237535L;

    @Override
    public String hello(final String nameParam) {
        return "Merhaba " + nameParam;
    }

    @Override
    public String goodbye(final String nameParam) {
        return "Güle güle " + nameParam;
    }

}
