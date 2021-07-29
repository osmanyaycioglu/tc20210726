package com.java.ee.training.person.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
                @NamedQuery(name = "find_by_username", query = "select p from PersonDTO p where p.username=?1"),
                @NamedQuery(name = "find_by_name_and_surname",
                            query = "select p from PersonDTO p where p.name=:isim and p.surname=:soy")

})
@Entity
@Table(name = "person",
       indexes = {
                   @Index(name = "first_index_1", columnList = "name,surname")
       })
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
    @Size(min = 5, max = 12)
    @Column(unique = true, nullable = false)
    private String       username;
    @NotEmpty
    @Size(min = 2, max = 25)
    private String       name;
    @NotEmpty
    @Column(length = 30)
    private String       surname;
    @NotNull
    private Integer      weight;
    @NotNull
    private Integer      height;

    @Embedded
    @NotNull
    private PersonDetail personDetail;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private Address      address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private Set<Phone>   phones;

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

    public Set<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(final Set<Phone> phonesParam) {
        this.phones = phonesParam;
    }


}
