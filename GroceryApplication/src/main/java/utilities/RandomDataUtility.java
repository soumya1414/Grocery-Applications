package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker f=new Faker();
	public String randomusername() {
		return f.name().username(); //name class its present
	}
public String randompassword() {//random creation we need usernanme and password only
	return f.internet().password();
}
public String randomfullname() {
	return f.name().fullName();
}
public String randommailid() {
	return f.internet().emailAddress();
}
}
