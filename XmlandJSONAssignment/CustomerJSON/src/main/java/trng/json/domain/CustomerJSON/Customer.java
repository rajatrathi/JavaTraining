package trng.json.domain.CustomerJSON;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class Customer 
{
	int customerId;
	String name;
	Date dataOfBirth;
	float annualSalary;
	Map < String, String> address;
	List<PaymentMethod> paymentMethod;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDataOfBirth() {
		return dataOfBirth;
	}
	public void setDataOfBirth(Date dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}
	public float getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(float annualSalary) {
		this.annualSalary = annualSalary;
	}
	public Map<String, String> getAddress() {
		return address;
	}
	public void setAddress(Map<String, String> address) {
		this.address = address;
	}
	public List<PaymentMethod> getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(List<PaymentMethod> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	

}
