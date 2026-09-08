package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker fk=new Faker();
	
	public String genarateRandomUserName() {
		return fk.name().username();
	}
	public String generateRandomPassword() {
		return fk.internet().password();
	}
	public String genarateRandomFullName() {
		return fk.name().fullName();
	}
	public String genarateRandomEmailID() {
		return fk.internet().emailAddress();
	}
	public String genarateRandomPhoneNumber() {
		return fk.phoneNumber().cellPhone();
	}


}
