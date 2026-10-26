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
		
	//	eList.stream()
	//	     .filter(e->e.sal>30000.0&&e.sal<46000.0)
	//	     .forEach((e)->System.out.println(e.fname));
		
		eList.stream()
			 .filter(e->e.sal>30000.0&&e.sal<46000.0)
			 .map(e->e.fname)
			 .forEach(System.out::println);
		
		System.out.println("=========");
		//9. WAP to display fname and lname from empList.
		
		eList.stream()
			 .map(e->e.fname+" "+e.lname)
			 .forEach(System.out::println);
		
		System.out.println("=========");
		
		//10. WAP to display the emp fname and sal if the emp is working for more than 45000.0
		
		eList.stream()
		     .filter(e->e.sal>45000.0)
		     .map(e->e.fname+" - "+e.sal)
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//11. WAP to display the emp fname, lname and job and dname if the emp is
		//working in IT or Sales Dept.
		
		eList.stream()
		     .filter(e->e.dname.equals("IT")||e.dname.equals("Sales"))
		     .map(e->e.fname+" - "+e.lname+" - "+e.job+" - "+e.dname)
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//12. WAP to display the first 3 characters of fname from emp data.
		
		eList.stream()
			 .map(e->e.fname.substring(0, 3))
			 .forEach(System.out::println);
		
		System.out.println("=========");
		
		//13. WAP to display the emp fname and lname in the below format.
		// Fname -> Siddarth
		// Lname -> Patil
		//Expected o/p : Siddarth.P
		
		eList.stream()
		     .map(e->e.fname+"."+e.lname.subSequence(0, 1))
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//14. WAP to display the first half of the fname.
		
		eList.stream()
		     .map(e->e.fname.substring(0, e.fname.length()/2))
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//15. WAP to display the second half of the fname.
		
		eList.stream()
			 .map(e->e.fname.substring(e.fname.length()/2))
			 .forEach(System.out::println);
		
		System.out.println("=========");
		
		//16. WAP to display the first half of the fname in lower case and
		   //second half in uppercase.
		
		System.out.println("=========");
		
		eList.stream()
		     .map(e->e.fname.substring(0, e.fname.length()/2).toLowerCase() //first half in lower
		    		+e.fname.substring(e.fname.length()/2).toUpperCase())  //second half in upper
             .forEach(System.out::println);

		System.out.println("=========");
		
		//17. WAP to display the first 3 emp records from empList.
		
		eList.stream()
		     .limit(3)
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//18. WAP to display the first 5 emp records from empList.
		
		eList.stream()
		     .limit(5)
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//19. WAP to display the first 2 emp records from empList.
		
		eList.stream()
	     .limit(2)
	     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//20. WAP to display the second emp record from empList.
		
		eList.stream()
		     .skip(1)
		     .limit(1)
		     .forEach(System.out::println);
	
		System.out.println("=========");
		
		//21. WAP to display the 4th and 5th record from empList.
		
		eList.stream()
		     .skip(3)
		     .limit(2)
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//22. WAP to display thr 7th record from empList.
		
		eList.stream()
		     .skip(6)
		     .limit(1)
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		
	    //23. WAP to display the different depts available in empList.
		
		eList.stream()
		     .map(e->e.dname)
		     .distinct()
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//24. WAP to display the different job roles available in empList.
		
		//25. WAP to display the different lnames available in empList.
		
		
		
		
		
	}
}
