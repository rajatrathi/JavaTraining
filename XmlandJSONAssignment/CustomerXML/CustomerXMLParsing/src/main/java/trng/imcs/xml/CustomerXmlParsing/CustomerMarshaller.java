package trng.imcs.xml.CustomerXmlParsing;

import static trng.imcs.xml.CustomerXmlParsing.CustomerUtil.createCustomer;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;

import trng.imcs.jaxb.Customer;



public class CustomerMarshaller 
{
	public static void main(String[] args) throws DatatypeConfigurationException {
		try {
			
			File file = new File("R:\\JAVA_SW_12_18\\Customer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Customer customer = createCustomer();
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		
		}
}
