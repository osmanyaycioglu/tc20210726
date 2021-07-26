package com.java.ee.training.rest;


public class PersonResponse {

    private String fullName;
    private String result;
    private int    errorCause;

    public String getFullName() {
        return this.fullName;
    }

    public PersonResponse setFullName(final String fullNameParam) {
        this.fullName = fullNameParam;
        return this;
    }

    public String getResult() {
        return this.result;
    }

    public PersonResponse setResult(final String resultParam) {
        this.result = resultParam;
        return this;
    }

    public int getErrorCause() {
        return this.errorCause;
    }

    public PersonResponse setErrorCause(final int errorCauseParam) {
        this.errorCause = errorCauseParam;
        return this;
    }

}
