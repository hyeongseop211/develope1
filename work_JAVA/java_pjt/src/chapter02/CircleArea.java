package chapter02;

public class CircleArea {
	public static void main(String[] args) {
		double pi=3.14;
		int radius=10;
		
//		숫자 연산시 결과는 큰 타입을 따라감
//		Type mismatch: cannot convert from double to int
//		int circleArea = pi*radius*radius;
//		원의 넓이 공식
		double circleArea = pi*radius*radius;
		
		System.out.println(circleArea);
	}
}
