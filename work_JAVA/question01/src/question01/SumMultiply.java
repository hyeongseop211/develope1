package question01;

import java.util.Scanner;

public class SumMultiply {
	public static void main(String[] args) {
		System.out.print("2개의 정수 입력>>");
		
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int result1 = a+b;
		int result2 = a*b;
		
		System.out.println("두 수의 합은"+result1);
		System.out.println("두 수의 곱은"+result2);
		
		scanner.close();
	}
}
