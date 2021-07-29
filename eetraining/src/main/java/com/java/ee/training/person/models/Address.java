package com.java.ee.training.person.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(pkColumnName = "generator",
                pkColumnValue = "AddressIdGen",
                name = "AddressGen",
                table = "pkgen",
                initialValue = 0,
                allocationSize = 100)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "AddressGen")
    private Long   addId;
    private String city;
    private String street;

    public String getCity() {
        return this.city;
    }

    public void setCity(final String cityParam) {
        this.city = cityParam;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String streetParam) {
        this.street = streetParam;
    }


}
