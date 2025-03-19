package question03;

import java.util.Scanner;

public class Tesla {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int dollar = 520;
		System.out.print("매수 수량을 입력하시오>>");
		int a = scanner.nextInt();
		
		int total = a*dollar;
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
