package question04;

import java.util.Scanner;

public class ArrayMin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numbers = new int[7];
		
		System.out.println("양수 7개를 입력하세요.");
		
		for (int i = 0; i < 7; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		int min = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		
		System.out.println("가장 작은 수는 "+min+"입니다.");
		scanner.close();
	}
}
