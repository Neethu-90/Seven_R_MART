package utility;

import com.github.javafaker.Faker;//to generate random test data.This helps us avoid using the same data every time and makes our tests more realistic and dynamic."

public class FakerUtility {

	Faker faker = new Faker();

	public String creatARandomFirstName() {

		return faker.name().firstName();

	}

	public String creatARandomLastName() {

		return faker.name().lastName();

	}

	public String generateAddress() {

		return faker.address().fullAddress();

	}

	public String generateEmail() {

		return faker.internet().emailAddress();

	}
}
