package question04;

import java.util.Scanner;

public class ArrayAccess {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numbers = new int[5];
		
		System.out.println("양수 5개를 입력하세요");
		for (int i = 0; i < 5; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		
		System.out.println("가장 큰 수는 " +max+"입니다");
		scanner.close();
	}
}
