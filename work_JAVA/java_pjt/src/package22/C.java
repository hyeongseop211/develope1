package package22;

import package21.A;

public class C {
	public static void main(String[] args) {
		A a=new A();
		a.field1=3;
//		default, private 는 다른 패키지에서 접근 불가
		
		a.method1();
//		default, private 는 다른 패키지에서 접근 불가
	}
}
