package chapter03;

import java.util.Scanner;

/*
 * 나눗셈(분자, 분모 입력 받음)
 * 몫을 출력(분모가 0인 경우 불능)
 */
public class DivideByZero {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dividend;
		int divisor;
		
		System.out.print("분자를 입력하시오>>");
		dividend = scanner.nextInt();
		System.out.print("분모를 입력하시오>>");
		divisor = scanner.nextInt();
		
//		분자를 입력하시오>>10
//		분모를 입력하시오>>0
//		=> 오류
		
		System.out.println(dividend+"를 "+divisor+"로 나누면 몫은 "+dividend/divisor+"입니다.");
		scanner.close();
	}
}










