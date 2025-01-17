package com.test.sec01;

import com.example.sec01.PersonOuterClass;
import com.example.sec01.PersonOuterClass.Person;

public class Test {
	
	public static void main(String[] args) {
		
		Person person = PersonOuterClass.Person.newBuilder()
						.setName("Tushar ")
						.setAge(26).build();
		
		System.out.println("Person object that we got\n age is :"+person.getAge()+"\nname :"+person.getName());
		
							
						
		
	}

}
