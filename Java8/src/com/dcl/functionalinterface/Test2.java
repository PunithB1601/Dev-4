package com.dcl.functionalinterface;
//to obtain length of given string

interface Demo1{
	public int findLength(String a);
}



public class Test2 {

	public static void main(String[] args) {
		Demo1 d1=(a)->a.length();
	//	Demo1 d2=b->b.length();
	System.out.println(d1.findLength("Shreyas"));	
		
	}
}
