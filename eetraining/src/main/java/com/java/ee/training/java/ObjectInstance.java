package com.java.ee.training.java;

import javax.inject.Inject;

public class ObjectInstance {

    @Inject
    private MyObject myObject;

    public void greetMe() {
        System.out.println(this.myObject.greet());
    }

    public static void main(final String[] args) {
        ObjectInstance instanceLoc = new ObjectInstance();
        MyObject myObjectLoc = new MyObject();
        instanceLoc.myObject = myObjectLoc;
        instanceLoc.greetMe();
    }
}
