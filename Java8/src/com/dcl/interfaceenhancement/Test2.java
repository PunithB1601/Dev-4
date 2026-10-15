package com.dcl.interfaceenhancement;

interface Restaurant{
	
	void chinese();
	
	void southIndian();
	
	void northIndian();
	
	default void mexican() {
		System.out.println("Mexican available");
	}
	
	static void italian() {
		System.out.println("Italian served here");
	}
}

class Mtr implements Restaurant{

	@Override
	public void chinese() {
		System.out.println("Chinese dishes available in MTR ");
	}

	@Override
	public void southIndian() {
		System.out.println("South Indian dishes available in MTR ");
	}

	@Override
	public void northIndian() {
		System.out.println("North Indian dishes available in MTR ");
	}
	
	
	
}

class Rameshwaram implements Restaurant {

	@Override
	public void chinese() {
		System.out.println("Chinese dishes available in Rameshwaram");
	}

	@Override
	public void southIndian() {
		System.out.println("SI dishes available in Rameshwaram ");
		
	}

	@Override
	public void northIndian() {
		System.out.println("NI dishes available in Rameshwaram ");
	}
	
	@Override
	public void mexican() {
		System.out.println("Mexican available in Rameshwaram");
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		
		Restaurant r1=new Rameshwaram();
		r1.chinese();
		r1.northIndian();
		r1.southIndian();
		r1.mexican();
		Restaurant.italian();
		
	}
}
