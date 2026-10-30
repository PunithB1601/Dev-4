package com.dcl.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Demo1 {

	public static void main(String[] args) {
		
	//	Date d=new Date();
	//	System.out.println(d);
		
		LocalDate d1=LocalDate.now();
		System.out.println(d1);
		LocalTime t1=LocalTime.now();
		System.out.println(t1);
		LocalDateTime d2=LocalDateTime.now().minusHours(5).plusDays(40);
		System.out.println(d2);
		
		
		
		
	}
}
