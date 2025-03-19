package question01;

import java.util.Scanner;

public class ExSumMultiply {
	public static void main(String[] args) {
		System.out.print("3자리수 정수 입력(100~999)>>");
		Scanner scanner=new Scanner(System.in);
		int number = scanner.nextInt();

		int ones = number%10;
		int tens = (number/10)%10;
		int hundreds = number/100;
		
		System.out.println("100의 자리와 10의 자리의 합은"+(tens+hundreds));
		System.out.println("10의 자리와 1의 자리의 곱은"+(ones*tens));
		
		scanner.close();
	}
}
