package question03;

import java.util.Scanner;

public class BreakExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("'exit'를 입력하면 종료됩니다.");
		
//		무한 반복: 반복횟수는 알수 없음 
		while (true) {
			System.out.print(">> ");
			String text = scanner.nextLine();
			
			if (text.equals("exit")) {
				break;
			}
//			System.out.println(text);
		}
		System.out.println("종료합니다....");
		scanner.close();
	}
}
