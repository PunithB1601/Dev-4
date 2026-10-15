package com.dcl.functionalinterface;

import java.util.function.Function;

public class Test9 {

	public static void main(String[] args) {
		
		//Return the length of given string
		Function<String, Integer> f1=(a)->a.length();
		Integer i=f1.apply("Mohan");
		System.out.println(i);
		
		//obtain the first 3 char from given string.
		Function<String, String> f2=(b)->b.substring(0, 3);
		System.out.println(f2.apply("Rajkumar"));
		
		
	}
}
