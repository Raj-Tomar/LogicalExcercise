package com.cookbook19.processing.json.data;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadWriteJackson2 {

	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInput = "{\"id\":0,\"firstName\":\"Robin\",\"lastName\":\"Wilson\"}";
		Person q = mapper.readValue(jsonInput, Person.class);
		System.out.println("Read and parsed Person from JSON: " + q);
		Person p = new Person("Roger", "Rabbit");
		System.out.print("Person object " + p + " as JSON = ");
		mapper.writeValue(System.out, p);
	}

}
