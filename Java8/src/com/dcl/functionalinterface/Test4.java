package com.dcl.functionalinterface;

import java.util.function.Predicate;

/**
interface Demo123{
	
	String verify(String name);
}

class Impl implements Demo123{

	@Override
	public String verify(String name) {
		boolean status=name.startsWith("S");
		if(status) {
			return name;
		}
		else {
			return null;
		}
	}
	
}

**/

/**
class DemoImpl implements Predicate<String>{

	
	(t)->t.startsWith("S");
		
	
}
**/

public class Test4 {
	
	public static void main(String[] args) {
		
		/**
		//1. To check whether the name starts with S or not.
		Demo123 d=new Impl();
		String a=d.verify("Sh");
		System.out.println(a);
		**/
		
		Predicate<String> p1=(t)->t.startsWith("S");
		String name="Sharath";
		if(p1.test(name)) {
			System.out.println(name);
		}
	}	
}
