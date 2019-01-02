package com.mocks.sample.mockitoSample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import lombok.Data;

@RestController
@RequestMapping("/post")
public class AllPostRequests {

	
	
	@RequestMapping(value="/postjson", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> createEmployee(@RequestBody String employee){
		try {
		Gson gson=new Gson();
		Employee emp=gson.fromJson(employee, Employee.class);
		if(employee==null || emp.name==null || emp.ageAndEarnedDegree.size()!=2) {
			return ResponseEntity.badRequest().body("Null Body Params not supported");
		}
		Integer ints=new Random().nextInt(10001)*100;
		return ResponseEntity.status(201).body("{\n\"id\":"+"\""+ints+"\"" +"\n}");
		}
		catch(NullPointerException e) {
			return ResponseEntity.badRequest().body("Null Body Params not supported");
		}
	}
}


@Data
class Employee{
	
	public String name;
	public String designation;
	public HashMap<String, String> address;
	public ArrayList<String> ageAndEarnedDegree;
	
	public Employee(String name, String designation, HashMap<String, String> address,
			ArrayList<String> ageAndEarnedDegree) {
		super();
		this.name = name;
		this.designation = designation;
		this.address = address;
		this.ageAndEarnedDegree = ageAndEarnedDegree;
	}
}

@Data 
class Address{
	
	public String location;
	public String city;
	public String pin;
	
	public Address returnAddress(String location, String city, String pin) {
		Address address=new Address();
		address.pin=pin;
		address.city=city;
		address.location=location;
		return address;
	}
	
}

