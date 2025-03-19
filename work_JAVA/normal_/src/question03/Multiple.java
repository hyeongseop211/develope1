package question03;

import java.util.Scanner;

public class Multiple {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean multiple; 
		multiple= false;
		System.out.print("양의 정수를 입력하세요: ");
		int number = scanner.nextInt();
		
		if (number%3==0) {
			multiple = true;
			System.out.println("3의 배수이다.");
		}
		if (number%5==0) {
			multiple = true;
			System.out.println("5의 배수이다.");
		}
		if (number%8==0) {
			multiple = true;
			System.out.println("8의 배수이다.");
		}
		if(!multiple) {
			System.out.println("어느 배수도 아니다.");
		}
		scanner.close();
	}




}
