package com.runnerclass;

import com.baseclass.PojoA;

public class PojoB {
	
public static void main(String[] args) {
	
	PojoA a=new PojoA();
	
	int a2 = a.getA();
	
	System.out.println("Before setter : "+a2);
	
	a.setA(1000);
	
	int a3 = a.getA();
	
	System.out.println("After setter : "+a3);
	
}
}
