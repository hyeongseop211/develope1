package question04;

import java.util.Scanner;

public class ArrayLength {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.print("5개의 정수를 입력하세요>>");
		int[] numbers = new int[5];
		double sum = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
			sum+=numbers[i];
		}
		
		double a = sum/numbers.length;
		System.out.println("평균은 "+a);
		
		scanner.close();
	}
}
