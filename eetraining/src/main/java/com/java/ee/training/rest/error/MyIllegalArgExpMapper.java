package com.java.ee.training.rest.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class MyIllegalArgExpMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(final IllegalArgumentException exceptionParam) {
        return Response.status(Response.Status.BAD_REQUEST)
                       .entity(new ErrorObj().setDescription("Yanlış argüman : " + exceptionParam.getMessage())
                                             .setCause(1001))
                       .header("Content-Type",
                               "application/json")
                       .build();
    }

}
