package com.lgy.spring_3_1;

public class Calculator {
	public void addition(int f,int s) {
		System.out.println("addition()");
		int result=f+s;
		System.out.println(f+"+"+s+"="+result);
	}
	public void sub(int f,int s) {
		System.out.println("sub()");
		int result=f-s;
		System.out.println(f+"-"+s+"="+result);
	}
	public void mul(int f,int s) {
		System.out.println("mul()");
		int result=f*s;
		System.out.println(f+"*"+s+"="+result);
	}
	public void div(int f,int s) {
		System.out.println("div()");
		int result=f/s;
		System.out.println(f+"/"+s+"="+result);
	}
}
