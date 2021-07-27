package com.java.ee.training.ejb;

public class CalculatorProxy extends Calculator {

    public CalculatorProxy() {
    }

    @Override
    public int add(final int i1,
                   final int i2) {
        Calculator calculatorLoc = null;
        // Pool a git bir instance all;

        int processLoc = calculatorLoc.add(i1,
                                           i2);

        // Pool instance ı pool a geri koyall;

        return processLoc;
    }

    @Override
    public int subs(final int i1,
                    final int i2) {
        Calculator calculatorLoc = null;
        // Pool a git bir instance all;

        int processLoc = calculatorLoc.subs(i1,
                                            i2);

        // Pool instance ı pool a geri koyall;

        return processLoc;
    }

}
