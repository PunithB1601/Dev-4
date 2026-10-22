package com.dcl.methods;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Test2 {

	public static void main(String[] args) {
		
		List<String> names= Arrays.asList("Ramu","Somu","Manu","Bhanu");
		
		//1st approach
		for(int i=0;i<names.size();i++) {
			System.out.println(names.get(i)); 
		}
		
		System.out.println("------");
		
		//2nd approach
		for(String name:names) {
			System.out.println(name);
		}
		
		System.out.println("------");
		
		//3rd approach
		Iterator<String> it=names.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("-------");
		
	//	Consumer<String> c1=(name)->System.out.println(name);
	//	names.forEach(c1);
		Consumer<String> c1=System.out::println;
		names.forEach(c1);
		
	}
}
