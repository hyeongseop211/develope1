package question06;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nums;
		int guess;
		
		Random random = new Random();
		nums = random.nextInt(10)+1;
		System.out.print("추측한 숫자를 입력하세요 : ");
		guess = scanner.nextInt();
		
		while (guess != nums) {
			
//			System.out.println("추측한 숫자가 틀렸습니다.");
			if(guess >10 || guess <0)
			{
				System.out.println("숫자가 범위를 벗어났습니다. 다시 입력하세요");
//				System.out.println("추측한 숫자가 틀렸습니다.");
				System.out.print("추측한 숫자를 입력하세요 : ");
				guess = scanner.nextInt();
				continue;
			}
			else {
//				System.out.print("추측한 숫자를 입력하세요 : ");
			}
			if (guess > nums) {
				System.out.println("추측한 숫자가 너무 큽니다.");
			}else {
				System.out.println("추측한 숫자가 너무 작습니다.");
			}
			System.out.print("추측한 숫자를 입력하세요 : ");
			guess = scanner.nextInt();
		}
		System.out.println("맞추셨습니다.");
		scanner.close();
		
		
		
		
	}


}
