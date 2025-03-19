package question04;

import java.util.Scanner;

public class ArrayTen {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numbers = new int [10];
		int sum =0;
		
		System.out.print("10개의 정수를 입력하세요>>");
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
			sum += numbers[i];
		}
		System.out.println("합계는 "+sum);
		
		scanner.close();
	}
}
