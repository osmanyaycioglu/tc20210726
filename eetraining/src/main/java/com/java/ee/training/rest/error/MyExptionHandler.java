package com.java.ee.training.rest.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception exceptionParam) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity(new ErrorObj().setDescription("Yanlış argüman : " + exceptionParam.getMessage())
                                             .setCause(5000))
                       .header("Content-Type",
                               "application/json")
                       .build();
    }

}
