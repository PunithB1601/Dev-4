package com.dcl.functionalinterface;

@FunctionalInterface
interface Demo{
	
	void xyz();
	
}

public class Test1 {

	public static void main(String[] args) {
		Demo d=()->System.out.println("xyz() called");
		d.xyz();
	}
}
