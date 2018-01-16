//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.15 at 10:35:41 PM CST 
//


package trng.imcs.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the trng.imcs.jaxb package. 
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

    private final static QName _Address_QNAME = new QName("http://trng.imcs.xsd/address", "Address");
    private final static QName _Customer_QNAME = new QName("http://trng.imcs.xsd/customer", "Customer");
    private final static QName _PaymentMethod_QNAME = new QName("http://trng.imcs.xsd/paymentMethod", "PaymentMethod");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: trng.imcs.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link PaymentMethod }
     * 
     */
    public PaymentMethod createPaymentMethod() {
        return new PaymentMethod();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trng.imcs.xsd/address", name = "Address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trng.imcs.xsd/customer", name = "Customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentMethod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trng.imcs.xsd/paymentMethod", name = "PaymentMethod")
    public JAXBElement<PaymentMethod> createPaymentMethod(PaymentMethod value) {
        return new JAXBElement<PaymentMethod>(_PaymentMethod_QNAME, PaymentMethod.class, null, value);
    }

}
