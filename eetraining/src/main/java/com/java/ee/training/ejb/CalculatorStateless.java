package com.java.ee.training.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class CalculatorStateless {

    @EJB
    AddProcess  addProcess;

    private int total;

    public CalculatorStateless() {
    }

    public int add(final int i1,
                   final int i2) {
        int processLoc = this.addProcess.process(i1,
                                                 i2);
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
