package question07;

import java.util.Scanner;

public class ChangeMoney {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};// 환산할 돈의 종류
		
//		금액 입력받기
		System.out.print("금액을 입력하시오>> ");
		int money = scanner.nextInt();
		
		
		for (int i = 0; i < unit.length; i++) {
			int count = money / unit[i]; // 금액의 갯수 계산
			if (count>0) { // 해당 금액이 있을 경우만 출력
				System.out.println(unit[i]+"원 짜리 : "+count+"개");
				money = money % unit[i]; // 남은 금액 계산 후 다시 위쪽으로
			}
		}
		
		scanner.close();
	}
}
