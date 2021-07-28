package com.java.ee.training.ejb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;


@Stateful
@LocalBean
public class Calculator implements Serializable {

    private static final long serialVersionUID = 2799369711061974461L;

    @EJB
    AddProcess                addProcess;

    private int               total;

    public Calculator() {
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

    @Remove
    public void removeAction() {
        System.out.println("Removed");
    }

    @PrePassivate
    public void prePasif() {
        System.out.println("PrePassivate");
    }

    @PostActivate
    public void postActif() {
        System.out.println("PostActivate");
    }

}
