package com.dcl.stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Emp {
	
	Integer eid;
	
	String fname;
	
	String lname;
	
	String job;
	
	Double sal;
	
	Integer dno;
	
	String dname;
	
	String location;
	
	String city;
	
	String state;

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", fname=" + fname + ", lname=" + lname + ", job=" + job + ", sal=" + sal + ", dno="
				+ dno + ", dname=" + dname + ", location=" + location + ", city=" + city + ", state=" + state + "]";
	}
	
	
	
}

class DBData {
	
	public static List<Emp> getEmpData(){
		List<Emp> empList=new ArrayList<Emp>();
		Emp e=null;
		
		String query=
				"SELECT * "
				+ "FROM EMP E JOIN DEPT D "
				+ "ON E.DNO=D.DNO JOIN LOCATION L "
				+ "ON D.LID=L.LID";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company_2","root", "tiger");
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				e=new Emp();
				e.eid=rs.getInt("eid");
				e.fname=rs.getString("fname");
				e.lname=rs.getString("lname");
				e.job=rs.getString("job");
				e.sal=rs.getDouble("sal");
				e.dno=rs.getInt("dno");
				e.dname=rs.getString("dname");
				e.location=rs.getString("location");
				e.city=rs.getString("city");
				e.state=rs.getString("state");
				empList.add(e);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return empList;
	}
	
}



public class Test2 {

	public static void main(String[] args) {
		List<Emp> eList=DBData.getEmpData();
		eList.forEach(System.out::println);
	}
}
