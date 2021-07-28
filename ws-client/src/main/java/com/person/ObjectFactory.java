
package com.person;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.person package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetallResponse_QNAME = new QName("http://ws.person.training.ee.java.com/", "getallResponse");
    private final static QName _AddResponse_QNAME = new QName("http://ws.person.training.ee.java.com/", "addResponse");
    private final static QName _GetResponse_QNAME = new QName("http://ws.person.training.ee.java.com/", "getResponse");
    private final static QName _Get_QNAME = new QName("http://ws.person.training.ee.java.com/", "get");
    private final static QName _Getall_QNAME = new QName("http://ws.person.training.ee.java.com/", "getall");
    private final static QName _Add_QNAME = new QName("http://ws.person.training.ee.java.com/", "add");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.person
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Add }
     * 
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link Getall }
     * 
     */
    public Getall createGetall() {
        return new Getall();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link GetallResponse }
     * 
     */
    public GetallResponse createGetallResponse() {
        return new GetallResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetallResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.person.training.ee.java.com/", name = "getallResponse")
    public JAXBElement<GetallResponse> createGetallResponse(GetallResponse value) {
        return new JAXBElement<GetallResponse>(_GetallResponse_QNAME, GetallResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.person.training.ee.java.com/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.person.training.ee.java.com/", name = "getResponse")
    public JAXBElement<GetResponse> createGetResponse(GetResponse value) {
        return new JAXBElement<GetResponse>(_GetResponse_QNAME, GetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Get }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.person.training.ee.java.com/", name = "get")
    public JAXBElement<Get> createGet(Get value) {
        return new JAXBElement<Get>(_Get_QNAME, Get.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getall }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.person.training.ee.java.com/", name = "getall")
    public JAXBElement<Getall> createGetall(Getall value) {
        return new JAXBElement<Getall>(_Getall_QNAME, Getall.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.person.training.ee.java.com/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<Add>(_Add_QNAME, Add.class, null, value);
    }

}
