package chapter05;

public class InstanceofExample {
	public static void method1(Parent parent) {
//		new Child();
		if (parent instanceof Child) {
//			down casting
			Child child = (Child) parent;
			System.out.println("method1 - Child 로 변환 성공");
		} else {
			System.out.println("method1 - Child 로 변환 실패");
		}
	}
	public static void main(String[] args) {
//		upcasting
		Parent parentA = new Child();
		method1(parentA);
		
		Parent parentB = new Parent();
		method1(parentB);
	}
}
