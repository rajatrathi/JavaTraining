package trng.imcs.xml.CustomerXmlParsing;


import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import trng.imcs.jaxb.Address;

import trng.imcs.jaxb.Customer;
import trng.imcs.jaxb.PaymentMethod;

public class CustomerUtil 
{
	public  static Customer createCustomer() throws DatatypeConfigurationException {
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(new Date());
		XMLGregorianCalendar date1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c1);
		GregorianCalendar c2 = new GregorianCalendar();
		c2.setTime(new Date());
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c2);
		
		GregorianCalendar c3 = new GregorianCalendar();
		c3.setTime(new Date());
		XMLGregorianCalendar date3 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c3);
		Customer customer = new Customer();
		customer.setCustomerId(101);
		customer.setName("Raman");
		customer.setAnnualSalary((float) 8000.0);
		customer.setDataOfBirth(date3);
	    Address address1 = new Address();
		address1.setStreetName("2567 E Vermont Street");
		address1.setZipCode(90817);
		Address address2 = new Address();
		address2.setStreetName("1987 W Garden Street");
		address2.setZipCode(78015);
		customer.getAddress().add(address1);
		customer.getAddress().add(address2);
		PaymentMethod paymethod1 = new PaymentMethod();
		paymethod1.setCardNumber(7890);
		paymethod1.setCardName("Discover");
		paymethod1.setDateFrom(date1);
		paymethod1.setDateType(date2);
		paymethod1.setCardType("DEBITCARD");
		PaymentMethod paymethod2 = new PaymentMethod();
		paymethod2.setCardNumber(7860);
		paymethod2.setCardName("Visa");
		paymethod2.setDateFrom(date1);
		paymethod2.setDateType(date2);
		paymethod2.setCardType("DEBITCARD");
		customer.getPaymentMethod().add(paymethod1);
		customer.getPaymentMethod().add(paymethod2);
		return customer;
	}
	
}
