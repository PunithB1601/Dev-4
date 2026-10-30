package com.dcl.stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
	
	

	public Integer getEid() {
		return eid;
	}



	public void setEid(Integer eid) {
		this.eid = eid;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public Double getSal() {
		return sal;
	}



	public void setSal(Double sal) {
		this.sal = sal;
	}



	public Integer getDno() {
		return dno;
	}



	public void setDno(Integer dno) {
		this.dno = dno;
	}



	public String getDname() {
		return dname;
	}



	public void setDname(String dname) {
		this.dname = dname;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



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
		
		eList.stream()
		     .map(e->e.job)
		     .distinct()
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//25. WAP to display the different lnames available in empList.
		
		eList.stream()
		     .map(e->e.lname)
		     .distinct()
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//26. WAP to display the emp records based on their sal from max to min.
		
		eList.stream()
		     .sorted(Comparator.comparing((Emp e)->e.sal).reversed())
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//27. WAP to display the emp fname in alphabetical order.
		
		eList.stream()
		     .sorted(Comparator.comparing(e->e.fname))
		     .map(e->e.fname)
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//28. WAP to display the emp details based on the sal from min to max.
		
		eList.stream()
		     .sorted(Comparator.comparing(e->e.sal))
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//29. WAP to display the first 5 minimum salaries.
		
		eList.stream()
		     .sorted(Comparator.comparing(e->e.sal))
		     .map(e->e.sal)
		     .distinct()
		     .limit(5)
		     .forEach(System.out::println);
		
		System.out.println("=========");
		
		//30. WAP to display the emp fname whose fname starts with S or K or A.
		//Display the names according to alphabetical orders.
		// Convert the final data into a list.
		
		List<String> empNames=
		eList.stream()
		     .filter(e->e.fname.startsWith("S")||e.fname.startsWith("K")||e.fname.startsWith("A"))
		     .sorted(Comparator.comparing(e->e.fname))
		     .map(e->e.fname)
		  // .forEach(System.out::println);
		     .collect(Collectors.toList());

		System.out.println("=========");
		
		//or
		
		eList.stream()
		     .filter(e->e.fname.startsWith("S"))
		     .sorted(Comparator.comparing(Emp::getFname))
		     .map(Emp::getFname)
		     .collect(Collectors.toList());
		     
		
		System.out.println("=========");
		//empNames.forEach(System.out::println);
		
		//31. WAP to display the emp data who are working as Developer. 
		//Convert the emp Info into a map by taking the eid as key and emp obj as value.
		
		Map<Integer, Emp> eMap=
		eList.stream()
		     .filter(e->e.job.equals("Developer"))
		    // .collect(Collectors.toMap(e->e.eid,e->e))
		     .collect(Collectors.toMap(Emp::getEid, e->e));
		
		System.out.println("=========");
		
		//32. WAP to display the emp data if the emp is working as salesman or manager.
		//Convert the emp data into a map by taking eid as key and 
		//  eid, fname, lname, job) as value.
		
		Map<Integer, Emp> eMapping=
		eList.stream()
		     .filter(e->e.job.equals("Salesman")||e.job.equals("Manager"))
		     .collect(Collectors.toMap(Emp::getEid, e->e));
		
		eMapping.forEach((eid, empInfo)->System.out.println(eid+" : "+empInfo));
		
		System.out.println("=========");
		
		//33. WAP to display the emp fname and convert it into a list.
		List<String> names=
		eList.stream()
		     .map(e->e.fname)
		     .collect(Collectors.toList());
		
		System.out.println("=========");
		
		//34. WAP to display the number of emps working as salesman.
		
		Long noOfSalesman=
		eList.stream()
		     .filter(e->e.job.equals("Salesman"))
		     .count();
		
		System.out.println(noOfSalesman);
		
		System.out.println("=========");
		
		//35. WAP to display the first element from the emp who are working in dept 113.
		
		Optional<Emp> oe=
		eList.stream()
		     .filter(e->e.dno==113)
		     .findFirst();
		
		System.out.println(oe.orElse(null));
		
		System.out.println("=========");
		
		//36. WAP to display the number of different job roles available
		// in the empList.
		
		System.out.println(
		eList.stream()
			 .map(e->e.job)
		     .distinct()
		     .count());
		
		System.out.println("=========");
		
		//37. WAP to obtain the first emp record who are working in Bangalore City.
		
		System.out.println(
		eList.stream()
		     .filter(e->e.city.equals("Bangalore"))
		     .findFirst().orElse(null)
		     );
		
		System.out.println("=========");
		
		//38. WAP to obtain the first emp record from Tamil Nadu state.
		
		System.out.println(
		eList.stream()
		     .filter(e->e.state.equals("Tamil Nadu"))
		     .findFirst().orElse(null)
		     );
		
		System.out.println("=========");
		
		//39. WAP to display the emps in each dept.
		
		Map<Integer, List<Emp>> empPerDept=
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getDno));
		
		empPerDept.forEach((dname,empL)->System.out.println(dname+" : "+empL));
		
		System.out.println("=========");
		
		//40. WAP to display the emps in each city
		
		
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getCity))
		     .forEach((city,empL)->System.out.println(city+" : "+empL));
		
		System.out.println("=========");
		
		//41. WAP to display the emps in each job role.
		
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getJob))
		     .forEach((job,empL)->System.out.println(job+" : "+empL));
		
		System.out.println("=========");
		
		//42. WAP to display the number of emps in each dept.
		
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getDname, Collectors.counting()))
		     .forEach((dname, count)->System.out.println(dname+" : "+count));
		
		System.out.println("=========");
		
		//43. WAP to display the number of emps in each city.
		
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getCity,Collectors.counting()))
		     .forEach((city,count)->System.out.println(city+" : "+count));
		
		System.out.println("=========");
		
		//44. WAP to display the number of emps in each job.
		
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getJob, Collectors.counting()))
		     .forEach((job,count)->System.out.println(job+" : "+count));
		
		System.out.println("=========");
		
		//45. WAP to display the maximum salary in each dept.
		Map<String, Optional<Emp>> maxSal=
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getDname, Collectors.maxBy(Comparator.comparing(Emp::getSal))))
		     ;
		maxSal.forEach((dname,o)->System.out.println(dname+" : "+o.orElse(null)));
		
		System.out.println("=========");
		
		//46. WAP to display the minimum salary in each dept.
		
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getDname,Collectors.minBy(Comparator.comparing(Emp::getSal))))
		     .forEach((dname,o)->System.out.println(dname+" : "+o.orElse(null).getSal()));
		
		System.out.println("=========");
		
		//47. WAP to display the max salary in each city.
		
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getCity, Collectors.maxBy(Comparator.comparing(Emp::getSal))))
		     .forEach((city,o)->System.out.println(city+" : "+o.orElse(null)));
		
		System.out.println("=========");
		
		//48. WAP to display the min salary in each job role.
		
		//49. WAP to display the total salary in each dept.
		
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getDname,Collectors.summingDouble(Emp::getSal)))
		     .forEach((dname, total)->System.out.println(dname+" "+total));
		
		System.out.println("=========");
		
		//50. WAP to display the avg salary in each dept.
		
		eList.stream()
		     .collect(Collectors.groupingBy(Emp::getDname, Collectors.averagingDouble(Emp::getSal)))
		     .forEach((dname,avg)->System.out.println(dname+" : "+avg));
		
	}
}
