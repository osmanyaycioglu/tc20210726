package com.java.ee.training.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class AddProcess {

    public int process(final int i1,
                       final int i2) {
        return i1 + i2;
    }
}
