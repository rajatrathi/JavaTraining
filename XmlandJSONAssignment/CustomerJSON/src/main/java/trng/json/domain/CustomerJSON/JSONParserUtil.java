package trng.json.domain.CustomerJSON;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONParserUtil {

	public static Customer createCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(101);
		customer.setName("Raju");
		customer.setAnnualSalary(1500f);
		customer.setDataOfBirth(new Date());
		Map<String,String> addressMap = new HashMap<>();
		addressMap.put("StreetName", "2567 E Vermont Street");
		addressMap.put("ZipCode", "90817");
		customer.setAddress(addressMap);
		List<PaymentMethod> paymentList = new ArrayList<>();
		PaymentMethod payment1 = new PaymentMethod();
		payment1.setCardNumber(1908);
		payment1.setCardName("Discover");
		payment1.setCardType("CREDITCARD");
		payment1.setDateFrom(new Date());
		payment1.setDateType(new Date());
		PaymentMethod payment2 = new PaymentMethod();
		payment2.setCardNumber(2608);
		payment2.setCardName("Visa");
		payment2.setCardType("DEBITCARD");
		payment2.setDateFrom(new Date());
		payment2.setDateType(new Date());
		paymentList.add(payment1);
		paymentList.add(payment2);
		customer.setPaymentMethod(paymentList);

		return customer;

	}

	public static void menu() {
		System.out.println("Press 0. for Serialize a Customer");
		System.out.println("Press 1. for DeSerialize a Customer into Customer Object");
		System.out.println("Press 2. for DeSerialize a Customer into Customer Map");
		System.out.println("Press 3. for exit");
	}

	public static void Serializer(String path) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Customer customer = createCustomer();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.writeValue(System.out, customer);
		objectMapper.writeValue(new PrintWriter(path), customer);
	}

	public static void DeSerializer(String path) throws IOException {

		byte[] jsonData = Files.readAllBytes(Paths.get(path));
		ObjectMapper objectMapper = new ObjectMapper();
		Customer customer = objectMapper.readValue(jsonData, Customer.class);
		System.out.println(ReflectionToStringBuilder.toString(customer));
	}
	public static void DeSerializerToMap(String path) throws IOException {
		byte[] jsonData = Files.readAllBytes(Paths.get(path));
		ObjectMapper objectMapper = new ObjectMapper();
		// Read JSON data into HashMap
		Map<String, Object> myMap = new HashMap<>();
		myMap = objectMapper.readValue(jsonData, HashMap.class);
		System.out.println("Map is: " + myMap);
	}

}
