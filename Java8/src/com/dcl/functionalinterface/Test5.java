package com.dcl.functionalinterface;

import java.util.function.Predicate;

//to check the given num is even or odd.

public class Test5 {

	public static void main(String[] args) {
		
		Predicate<Integer> p1=(num)->num%2==0;
		
		if(p1.test(5)) {
			System.out.println("Even");
		}
		else {
			System.out.println("Odd");
		}
	}
}
