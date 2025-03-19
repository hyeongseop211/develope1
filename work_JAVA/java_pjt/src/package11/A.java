package package11;

public class A {
	A a1 = new A(true);// 객체 생성
	A a2 = new A(1);// 객체 생성
	A a3 = new A("문자열");// 객체 생성
	
	// 생성자
	public A(boolean b) {
	}
//	오버로딩
	A(int b) {// default 접근 지정자
	}
	
//	private A(String s) {// private 접근 지정자
	A(String s) {// default 접근 지정자
	}
}