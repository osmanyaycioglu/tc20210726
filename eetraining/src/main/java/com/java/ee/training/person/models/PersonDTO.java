package com.java.ee.training.person.models;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "person")
@TableGenerator(pkColumnName = "generator",
                pkColumnValue = "PersonDTOIdGen",
                name = "xyz",
                table = "pkgen",
                initialValue = 1,
                allocationSize = 100)
public class PersonDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "xyz")
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xyz")
    private Long         personId;

    @NotEmpty
    private String       username;
    @NotEmpty
    private String       name;
    @NotEmpty
    private String       surname;
    @NotNull
    private Integer      weight;
    @NotNull
    private Integer      height;

    @Embedded
    @NotNull
    private PersonDetail personDetail;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address      address;

    @Version
    private Long         mver;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }

    public PersonDetail getPersonDetail() {
        return this.personDetail;
    }

    public void setPersonDetail(final PersonDetail personDetailParam) {
        this.personDetail = personDetailParam;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address addressParam) {
        this.address = addressParam;
    }

    public Long getMver() {
        return this.mver;
    }

    public void setMver(final Long mverParam) {
        this.mver = mverParam;
    }

}
