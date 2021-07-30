package com.java.ee.training.cdi;

import java.io.Serializable;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Named("esp")
@Alternative
public class SpanishGreet implements IGreet, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8730828166826143818L;

    @Override
    public String hello(final String nameParam) {
        return "Hola " + nameParam;
    }

    @Override
    public String goodbye(final String nameParam) {
        return "Adios " + nameParam;
    }

}
