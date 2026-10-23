package com.dcl.stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
		//eList.forEach(System.out::println);
		
		//1. WAP to obtain the emp data who are working as Salesman.
		
	//	Stream<Emp> s1=eList.stream(); //creation of stream/ list converted to stream
	//	Predicate<Emp> p1=(e)->e.job.equalsIgnoreCase("Salesman"); //condition created
	//	Stream<Emp> s2=s1.filter(p1);
	//	s2.forEach(System.out::println);
		
		eList.stream()
			 .filter((e)->e.job.equals("Salesman"))
			 .forEach(System.out::println);
		
		System.out.println("=========");
		
		//2. WAP to display the emp records whose sal is more than 40000.
		
		eList.stream()
		     .filter((e)->e.sal>40000.0)
		     .forEach(System.out::println);
		
		System.out.println("=========");
		//3. WAP to display the emp records whose fname starts with 'S'.
		
		eList.stream()
			 .filter((e)->e.fname.startsWith("S"))
			 .forEach(System.out::println);
		
		System.out.println("=========");
		//4. WAP to display the emp data if the emp is working in IT dept or Sales dept.
	
		eList.stream()
			 .filter((e)->e.dname.equals("IT")||e.dname.equals("Sales"))
			 .forEach(System.out::println);
		
		System.out.println("=========");
		//5. WAP to display the emp data who are working in Bangalore (City).
		
		eList.stream()
			 .filter((e)->e.city.equals("Bangalore"))
			 .forEach(System.out::println);
		
		System.out.println("=========");
		//6. WAP to display the emp data who are working as Salesman or Manager in dept 110.
		
		eList.stream()
		     .filter((e)->(e.job.equals("Salesman")||e.job.equals("Manager"))&&e.dno==110)
		     .forEach(System.out::println);
		
		System.out.println("=========");
		//7. WAP to display the emp data whose fname starts with S or K or A.
		
		eList.stream()
			 .filter((e)->e.fname.startsWith("S")||e.fname.startsWith("K")||e.fname.startsWith("A"))
			 .forEach(System.out::println);
		
		System.out.println("=========");
		//8. WAP to display the emp fname who is getting sal more than 30000 but less than 46000.
		
		eList.stream()
			 .filter((e)->e.sal>30000.0&&e.sal<46000.0)
			 .forEach((e)->System.out.println(e.fname));
	}
}
