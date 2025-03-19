package question01;

import java.util.Scanner;

//class 여러개 사용해도 무관
class Aaa{}
class Bbb{}
//The public type Caa must be defined in its own file
//public class Caa{}
//1. JVM이 수많은 class 에서 public class 를 찾아감
public class ExCalculation {
	
	public static void aaa() {
		System.out.println("777");
		
	}
	public static void bbb() {
		System.out.println("888");
		
	}
//	2.JVM이 수많은 method 에서 main 메소드를 찾아감
	public static void main(String[] args) {
		System.out.print("2개의 실수 입력>>");
		
		Scanner scanner = new Scanner(System.in);
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		
		System.out.println("두수의 덧셈은"+(a+b));
		System.out.println("두수의 뺄셈은"+(a-b));
		System.out.println("두수의 곱셈은"+a*b);
		System.out.println("두수의 나눗셈은"+a/b);
		
		scanner.close();
		
	}
}
