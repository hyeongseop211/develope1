package question01;

import java.util.Scanner;

public class DivAndRemains {
	public static void main(String[] args) {
		System.out.print("2자리수 정수 입력(10~99)>>");
		Scanner scanner=new Scanner(System.in);
		
		int number =scanner.nextInt();
		
		int ones = number % 10;
		int tens = number / 10;
		
		if (ones==tens) {
			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
		} else {
			System.out.println("다릅니다.");

		}
		scanner.close();
	}
}
