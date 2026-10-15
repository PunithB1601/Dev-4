package com.dcl.functionalinterface;

import java.util.function.Predicate;

public class Test6 {

	public static void main(String[] args) {
		
		String[] names= {"Ramu","Akash","Ajay","Raju","Shreya","Ravi"};
		//1. Display the names which starts with R by
		// using predicate
		
		Predicate<String> p1=(name)->name.startsWith("R");
		
		for(String a:names) {
			if(p1.test(a)) {
				System.out.println(a);
			}
		}
		
		System.out.println("============");
		
		Predicate<String> p2=(name)->name.length()>4;
		
		for(String b:names) {
			if(p2.test(b)) {
				System.out.println(b);
			}
		}
		
		//2. Display the names if the length of name
		// is more than 4 chars.
		
	}
}
