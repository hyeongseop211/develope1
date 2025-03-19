package question07;

import java.util.Scanner;

public class ComputeInterest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double principal = 0; //원금
		double rate = 0; // 연이율
		double balance = 0; // 원리금
		int years = 0; // 연도수
		
		System.out.print("원금을 입력하세요: ");
		principal = scan.nextDouble();
		System.out.print("연이율을 입력하세요: ");
		rate = scan.nextDouble();
		
		balance = principal;
		System.out.print("연도수"+" \t "+"원리금");
		System.out.println();
		
		while (balance < principal*2) {
			balance = balance *(1.0+rate/100.0);
			years++;
			System.out.println(years+" \t " +balance);
		}
		
		System.out.println("필요한 연도수 : "+years);
		scan.close();
	}
}
