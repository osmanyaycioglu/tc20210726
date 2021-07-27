package com.java.ee.training.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class CalculatorSingleton {

    private int total;

    private synchronized void addToTotal(final int total) {
        this.total += total;
    }


    public int add(final int i1,
                   final int i2) {
        int processLoc = i1 + i2;
        this.addToTotal(processLoc);
        return processLoc;
    }

    public int subs(final int i1,
                    final int i2) {
        int processLoc = i1 - i2;
        this.addToTotal(-1 * processLoc);
        return processLoc;
    }

    public int getTotal() {
        return this.total;
    }

}
