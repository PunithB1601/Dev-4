package com.dcl.methods;

@FunctionalInterface
interface Demo {
	public int add(int a, int b);
}

class DemoImpl implements Demo{

	@Override
	public int add(int a, int b) {
		Test1 t=new Test1();
		return t.multiply(a, b);
	}
	
}

public class Test1 {
	
	public Test1() {
		
	}
	
	public Test1(int m, int n) {
		System.out.println("Param con called");
	}
	

	public static void main(String[] args) {
		
		//Approach-1
		Demo d1=new DemoImpl();
		System.out.println(d1.add(7, 8));
		
		System.out.println("==========");
		
		//Approach-2
		Demo d2=(a,b)->a+b;
		System.out.println(d2.add(10, 20));
		
		//Approach-3
		Test1 t=new Test1();
		Demo d3=(a,b)->t.multiply(a,b);
		System.out.println(d3.add(20,10));
		
		//Approach-4
	//  FI ref-var=class-ref-var::insance-method-name
		Demo d4=t::multiply;
		System.out.println(d4.add(25, 4));
		
		//Approach-5
	//  FI ref-var=Class-name::static-method-name
		Demo d5=Test1::sub;
		System.out.println(d5.add(4, 2));
		
		//Approach-6 [COnstructor reference]
	//	Demo d6=Test1::new;
	}
	
	public int multiply(int x, int y) {
		return x*y;
	}
	
	public static int sub(int c, int d) {
		return c-d;
	}
}
