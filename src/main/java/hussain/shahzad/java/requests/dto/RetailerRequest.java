package hussain.shahzad.java.requests.dto;

import com.poiji.annotation.ExcelCell;

/**
 * 
 * @author shahzad
 *
 */
public class RetailerRequest {

	@ExcelCell(0)
	public String city;

	@ExcelCell(1)
	public String country;

	@ExcelCell(2)
	public String gender;

	@ExcelCell(3)
	public String currency;

	@ExcelCell(4)
	public String balance;

	@ExcelCell(5)
	public String mobile;

	@ExcelCell(6)
	public String email;

	public RetailerRequest() {
	}

	@Override
	public String toString() {
		return "RetailerRequest [city=" + city + ", country=" + country + ", gender=" + gender + ", currency="
				+ currency + ", balance=" + balance + ", mobile=" + mobile + ", email=" + email + "]";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
