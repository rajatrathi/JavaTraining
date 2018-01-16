package trng.json.domain.CustomerJSON;

import java.util.Date;


public class PaymentMethod 
{

	int cardNumber;
	String cardName;
	Date dateFrom;
	Date dateType;
	String cardType; 

	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateType() {
		return dateType;
	}
	public void setDateType(Date dateType) {
		this.dateType = dateType;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
