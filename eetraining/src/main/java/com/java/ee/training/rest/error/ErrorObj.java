package com.java.ee.training.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         description;
    private int            cause;

    public String getDescription() {
        return this.description;
    }

    public ErrorObj setDescription(final String descriptionParam) {
        this.description = descriptionParam;
        return this;
    }

    public int getCause() {
        return this.cause;
    }

    public ErrorObj setCause(final int causeParam) {
        this.cause = causeParam;
        return this;
    }

    public ErrorObj addSubError(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjParam);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public void setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
    }


}
