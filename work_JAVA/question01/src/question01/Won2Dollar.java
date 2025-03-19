package question01;

import java.util.Scanner;
public class Won2Dollar {
	public static void main(String[] args) {
//		int rate=1100;
//		환율 고정할때 상수 사용(관습적으로 대문자)
		final int RATE=1100;
		System.out.print("원화를 입력하세요(단위 원)>>");
		
		Scanner scanner = new Scanner(System.in);
		
		int won =scanner.nextInt();
		
		double dollar = won/RATE;
		
		System.out.println(won+"원은 $"+dollar+"입니다." );
		
		scanner.close();
				
	}
}
