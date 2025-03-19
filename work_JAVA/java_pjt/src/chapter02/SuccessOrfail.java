package chapter02;

import java.util.Scanner;

/*
 * 점수를 입력받아서 80점 이상이면 합격
 */
public class SuccessOrfail {
	public static void main(String[] args) {
		System.out.print("점수를 입력하시오 : ");
		Scanner scanner=new Scanner(System.in);
		int score = scanner.nextInt();
		
//		80점 이상인 경우
//		if (score >= 80) {
//			System.out.println("축하합니다! 합격입니다.");
//		}
		
//		if (score >= 80) 
//			System.out.println("축하합니다! 합격입니다.");
//		실행문이 2개 이상일때 조건이 거짓이면 오류 발생(중괄호 필요)
//		if (score >= 80) 
//			System.out.println("축하합니다!");
//			System.out.println("합격입니다.");
		if (score >= 80) {
			System.out.println("축하합니다!");
			System.out.println("합격입니다.");
		}
//		if (score >= 80) System.out.println("축하합니다!");System.out.println("합격입니다.");
//		if (score >= 80) {System.out.println("축하합니다!");System.out.println("합격입니다.");}
		
		
		scanner.close();
	}
}
