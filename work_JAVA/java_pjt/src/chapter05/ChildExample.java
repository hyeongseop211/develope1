package chapter05;

public class ChildExample {
	public static void main(String[] args) {
//		Parent 클래스에 기본생성자 만들어서 호출하고,
//		child 클래스에 기본생성자 만들어서 호출
//		upcasting(super class 타입으로 sub class 객체 생성)
		Parent parent = new Child();
		parent.field1="data1";
//		upcasting 된 객체는 서브클래스 멤버 접근 불가
//		parent.field2="data2"; //오류
		parent.method1();
		parent.method2();
//		upcasting 된 객체는 서브클래스 멤버 접근 불가
//		parent.method3(); //오류
		
		Child child = (Child)parent; // down casting
//		down casting 객체는 서브클래스 멤버 접근 가능
		child.field2="yyy";
		child.method3();
	}
}
