package com.java.ee.training.cdi;

import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class GreetConfig {

    @Produces
    @Named("dyn")
    @RequestScoped
    public IGreet createGreetImpl() {
        Random randomLoc = new Random();
        int nextIntLoc = randomLoc.nextInt(3);
        switch (nextIntLoc) {
            case 0:
                return new EnglishGreet();
            case 1:
                return new TurkishGreet();
            case 2:
                return new SpanishGreet();
            default:
                return new EnglishGreet();
        }
    }

}
