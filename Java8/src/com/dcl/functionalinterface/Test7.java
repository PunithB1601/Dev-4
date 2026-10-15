package com.dcl.functionalinterface;

import java.util.function.Consumer;

/**
interface Demo12{
	
	void displayName(String name);
}

class Impl implements Demo12 {

	@Override
	public void displayName(String name) {
		System.out.println("Name is "+name);
	}
}

**/
public class Test7 {

	public static void main(String[] args) {
		
		//Demo12 d=new Impl();
		//d.displayName("Rahul");
		
		Consumer<String> c1=(name)->System.out.println("Name is "+name);
		c1.accept("Mukesh");
		
		
		
	}
}
