package com.java.ee.training.cdi.interceptor;

import javax.inject.Inject;

public class Caller {

    @Inject
    private Callee callee;

    @Tutucu
    @MyAnnotation("deneme")
    public String callOther(final String str) {
        return this.callee.callMe(str);
    }

}
