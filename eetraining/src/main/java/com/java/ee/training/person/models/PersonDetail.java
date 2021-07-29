package com.java.ee.training.person.models;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class PersonDetail {

    @Enumerated(EnumType.STRING)
    private EGender gender;
    private String  note;

    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(final String noteParam) {
        this.note = noteParam;
    }


}
