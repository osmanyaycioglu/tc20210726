
package com.training.rest.client.restclient;

public class Person {

    protected Integer height;
    protected String  name;
    protected String  surname;
    protected String  username;
    protected Integer weight;

    /**
     * Gets the value of the height property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getHeight() {
        return this.height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setHeight(final Integer value) {
        this.height = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Gets the value of the surname property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Sets the value of the surname property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSurname(final String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the username property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the value of the username property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUsername(final String value) {
        this.username = value;
    }

    /**
     * Gets the value of the weight property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getWeight() {
        return this.weight;
    }

    /**
     * Sets the value of the weight property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setWeight(final Integer value) {
        this.weight = value;
    }

    @Override
    public String toString() {
        return "Person [height="
               + this.height
               + ", name="
               + this.name
               + ", surname="
               + this.surname
               + ", username="
               + this.username
               + ", weight="
               + this.weight
               + "]";
    }


}
