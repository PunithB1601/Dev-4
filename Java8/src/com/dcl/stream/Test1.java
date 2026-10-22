package com.dcl.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		
		List<Integer> iList=Arrays.asList(1,2,3,6,7,4,8,9,0);
		//Approach-1 To create Stream
		Stream<Integer> s1=Stream.of(1,2,5,7,9,0,2,4,6);
		s1.forEach(System.out::println);
		
		System.out.println("========");
		
		//Approach-2 To create Stream
		Stream<Integer> s2=iList.stream();
		s2.forEach(System.out::println);
		
	}
}
