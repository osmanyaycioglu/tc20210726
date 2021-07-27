package com.java.ee.training.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class CalculatorSingleton {

    private int total;


    public int add(final int i1,
                   final int i2) {
        int processLoc = i1 + i2;
        this.total += processLoc;
        return processLoc;
    }

    public int subs(final int i1,
                    final int i2) {
        int processLoc = i1 - i2;
        this.total -= processLoc;
        return processLoc;
    }

    public int getTotal() {
        return this.total;
    }

}
