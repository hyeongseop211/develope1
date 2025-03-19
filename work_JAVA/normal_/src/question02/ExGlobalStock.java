package question02;

import java.util.Scanner;

public class ExGlobalStock {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("매수금액을 입력하세요: ");
		int pay = scanner.nextInt();
		System.out.print("매도금액을 입력하세요: ");
		int sell= scanner.nextInt();
		int result = 0;
		
//		int result = 0;
		
		if (sell>pay) {
			result = (sell-pay)*22/100;
		}
		else {
			result=0;
		}
		System.out.println("양도세 = "+result);
		scanner.close();
	}




}
