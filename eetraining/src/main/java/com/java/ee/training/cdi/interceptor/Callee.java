package com.java.ee.training.cdi.interceptor;


public class Callee {

    @Tutucu
    @MyAnnotation("test")
    public String callMe(final String str) {
        return "Callee called by  : " + str;
    }

}
