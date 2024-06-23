package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class Controller {
	@RequestMapping("")
	public String greating(@RequestParam(name = "name",required=false) String firstName,@RequestParam(name = "last_name",required=false) String lastName,@RequestParam(name = "times",required=false) Integer times) {
		if (firstName == null) {
			return "Hello Human";
		} else if (lastName == null && times == null) {
		return "Hello " + firstName;
		} else if (lastName == null && times != null) {
			String result = new String();
			for (int i=0; i< times;i++) {
				result += "Hello " + firstName + "\n";
			}
			return result;
		} else if (firstName != null && lastName != null) {			
			return "Hello " + firstName +" " + lastName;
		}
		return "Hello Human";
	}
}
