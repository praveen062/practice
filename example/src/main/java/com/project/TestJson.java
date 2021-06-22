package com.project;

import java.util.ArrayList;
import java.util.List;

public class TestJson {
	
	
	public static void main(String[] args) {
		A a = new A();
		a.a = 10;
		a.B = "praveen";
		B b = new B();
		List<A> as = new ArrayList<A>();
		as.add(a);
		as.add(a);
		b.a = as;
		System.out.println(b);
	}
}


class B {
	List<A> a;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{ \"a\":"+a+"}";
	}
}

class A {
	int a;
	String B;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "{\"a\":"+a+", \"B\":\""+B+"\"}";
	}
}