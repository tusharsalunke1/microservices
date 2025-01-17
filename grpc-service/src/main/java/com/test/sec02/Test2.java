package com.test.sec02;

import com.example.sec01.PersonOuterClass;
import com.example.sec01.PersonOuterClass.Person;

public class Test2 {

	
	public static void main(String[] args) {
		
		/*	 here we can access Person directly by generating multiple files
			beacause : 	option java_multiple_files=true;

		 before we were doing like this 
		 * PersonOuterClass.Person.newBuilder() .setName("Tushar ") .setAge(26).build();
		 */
		Person.newBuilder().setName("ok").setAge(123).build();
		
	}
}
