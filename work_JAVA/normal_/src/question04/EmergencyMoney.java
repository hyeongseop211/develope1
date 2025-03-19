package question04;

import java.util.Scanner;

public class EmergencyMoney {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int dollar = 1200;
		System.out.print("가구수를 입력하시오>>");
		int a = scanner.nextInt();
		
		int support;
		if (a ==1) {
			support = 400000;
		}else if (a == 2) {
			support = 600000;
		}else if (a == 3) {
			support = 800000;
		}  
		else {
			support=1000000;
		}
		
		int total = support/dollar;
		int hundred = total/100;
		int remainder = total%100;
		int tens = remainder/10;
		
		System.out.println("100달러짜리"+hundred+"매");
		if (tens >0) {
			System.out.println("10달러짜리"+tens+"매");
		}
		
		scanner.close();
	}

}
