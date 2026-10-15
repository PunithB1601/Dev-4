package com.dcl.functionalinterface;

interface AddOperator{
	
	public int add(int a, int b);
}

class AOImpl implements AddOperator {

	@Override
	public int add(int a, int b) {
		return a+b;
	}
	
}

public class Test3 {

}
