package question01;

import java.util.Scanner;

public class ExExchange {
	public static void main(String[] args) {
		final double DOLLA_RATE=1200;
		final double EURO_RATE=1500;
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("원화를 입력하세요(단위 원)>>");
		int won =scanner.nextInt();
		
		double dollar = won/DOLLA_RATE;
		double euro = won/EURO_RATE;
		
		System.out.println(won+"원은 $"+dollar+"입니다." );
		System.out.println(won+"원은 E"+euro+"입니다." );
		
		scanner.close();
	}
}
