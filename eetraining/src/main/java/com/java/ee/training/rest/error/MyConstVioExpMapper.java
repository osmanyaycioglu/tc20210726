package com.java.ee.training.rest.error;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class MyConstVioExpMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exceptionParam) {
        ErrorObj rootExp = new ErrorObj().setDescription("Validasyon hatası")
                                         .setCause(2000);
        Set<ConstraintViolation<?>> constraintViolationsLoc = exceptionParam.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolationLoc : constraintViolationsLoc) {
            rootExp.addSubError(new ErrorObj().setDescription(constraintViolationLoc.getMessage())
                                              .setCause(2100));
        }

        return Response.status(Response.Status.BAD_REQUEST)
                       .entity(rootExp)
                       .header("Content-Type",
                               "application/json")
                       .build();
    }

}
