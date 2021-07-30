package com.java.ee.training.cdi.interceptor;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Tutucu
public class TutucununInterceptor {

    @AroundInvoke
    public Object xyz(final InvocationContext ic) {
        try {
            Method methodLoc = ic.getMethod();
            String chng = "changed ";
            MyAnnotation annotationLoc = methodLoc.getAnnotation(MyAnnotation.class);
            if (annotationLoc != null) {
                chng = annotationLoc.value() + " ";
            }
            System.out.println("Method will be called : " + methodLoc.getName());
            Parameter[] parameters2Loc = methodLoc.getParameters();
            System.out.println("Before Tutucu method");
            long nanoTimeLoc = System.nanoTime();
            Object[] parametersLoc = ic.getParameters();
            String strVal1 = (String) parametersLoc[0];
            strVal1 = chng + strVal1;
            Object[] newParLoc = new Object[1];
            newParLoc[0] = strVal1;
            ic.setParameters(newParLoc);
            Object proceedLoc = ic.proceed();
            if (proceedLoc instanceof String) {
                String stringLoc = (String) proceedLoc;
                stringLoc += " intercepted";
                proceedLoc = stringLoc;
            }
            nanoTimeLoc = System.nanoTime() - nanoTimeLoc;
            System.out.println("After Tutucu method : " + nanoTimeLoc);
            return proceedLoc;
        } catch (Throwable eLoc) {
            eLoc.printStackTrace();
            return null;
        }
    }

}
