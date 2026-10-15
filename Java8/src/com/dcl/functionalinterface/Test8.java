package com.dcl.functionalinterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Supplier;

public class Test8 {

	public static void main(String[] args) {
		
		Supplier<String> s1=()->"Raju";
		Supplier<Connection> s2=()->
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				return DriverManager.getConnection("demo");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			return null;
		};
	}
}
