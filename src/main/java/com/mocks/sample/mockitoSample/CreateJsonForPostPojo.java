package com.mocks.sample.mockitoSample;

import java.util.ArrayList;
import com.google.gson.Gson;
import lombok.Data;

@Data
public class CreateJsonForPostPojo {

	public String name;
	public String designation;
	public NewAddress address;
	public ArrayList<String> ageAndEarnedDegree;
	public Object pojoobj;
	
	public CreateJsonForPostPojo() {}
	
	public CreateJsonForPostPojo(String name, String designation, NewAddress address,ArrayList<String> ageandearned) {
		this.name=name;
		this.designation=designation;
		this.address=address;
		this.ageAndEarnedDegree=ageandearned;	
	}
 
	public String getPojo(String name,String designation,String location,String city,String pin,String age,String qualif) {
		NewAddress address=new NewAddress(location,city,pin);
		ArrayList<String> str=new ArrayList<String>();
		str.add(age);
		str.add(qualif);
		CreateJsonForPostPojo createJsonForPostPojo=new CreateJsonForPostPojo(name, designation, address, str);
		Gson gson=new Gson();
		return gson.toJson(createJsonForPostPojo);
	}
	
	
}

@Data 
class NewAddress{
	
	public String location;
	public String city;
	public String pin;
	
	public NewAddress(String location, String city, String pin) {
		this.pin=pin;
		this.city=city;
		this.location=location;
	}
	
}
