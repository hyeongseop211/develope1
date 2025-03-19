package question01;

import java.util.Scanner;

public class q1 {
	public static void main(String[] args) {
		System.out.print("반지름을 입력하세요>>");
//		Scanner 객체 생성
		Scanner scanner = new Scanner(System.in);
//		반지름을 정수로 입력받음
		int ban = scanner.nextInt(); 
		
		double result = 3.14*ban*ban;
		System.out.println("원의 면적은"+result+"입니다.");
		
		scanner.close();
	}
}
