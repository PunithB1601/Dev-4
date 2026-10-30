package com.dcl.stream;

import java.util.Optional;

public class Test3 {

	public static void main(String[] args) {
		
		String name=null;
	//	System.out.println(name);
		
		Optional<String> opt=Optional.ofNullable(null);
		System.out.println(opt.orElseThrow(()->new RuntimeException("No data found!")));
		
		
	}
}
