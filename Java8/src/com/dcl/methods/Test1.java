package com.dcl.methods;

@FunctionalInterface
interface Demo {
	public int add(int a, int b);
}

class DemoImpl implements Demo{

	@Override
	public int add(int a, int b) {
		return a+b;
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		//Approach-1
		Demo d1=new DemoImpl();
		System.out.println(d1.add(7, 8));
		
		System.out.println("==========");
		
		//Approach-2
		Demo d2=(a,b)->a+b;
		System.out.println(d2.add(10, 20));
		
		
		
	}
	
	public int multiply(int x, int y) {
		return x*y;
	}
}
