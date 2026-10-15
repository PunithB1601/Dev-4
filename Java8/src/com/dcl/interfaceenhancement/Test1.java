package com.dcl.interfaceenhancement;

interface DCL{
	
	void jfs();
	
	void pfs();
	
	default void devops() {
		System.out.println("Devops delivered in this branch");
	}
	
}

class BTM implements DCL{

	@Override
	public void jfs() {
		System.out.println("Java Full Stack delivered in BTM");
	}

	@Override
	public void pfs() {
		System.out.println("Python Full Stack delivered in BTM");
	}
	
}

class Raj implements DCL{

	@Override
	public void jfs() {
		System.out.println("Java Full Stack deluvered in Raj");
	}

	@Override
	public void pfs() {
		System.out.println("Java Full Stack deluvered in Raj");
	}
	
	@Override
	public void devops() {
		// TODO Auto-generated method stub
		DCL.super.devops();
	}
	
}


public class Test1 {
	
	public static void main(String[] args) {
		
		DCL btm=new BTM();
		btm.jfs();
		btm.pfs();
		
		System.out.println("+===========+");
		
		DCL raj=new Raj();
		raj.jfs();
		raj.pfs();
		raj.devops();
	}
}
