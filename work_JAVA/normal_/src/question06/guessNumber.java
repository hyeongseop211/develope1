package question06;

import java.util.Random;
import java.util.Scanner;

public class guessNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int nums = random.nextInt(10)+1;
		int guess;
		
		while (true) {
			System.out.print("추측한 숫자를 입력하세요 : ");
			guess = scanner.nextInt();
			if(guess >10 || guess <0)
			{
				System.out.println("숫자가 범위를 벗어났습니다. 다시 입력하세요");
				continue;
			}
			
			if (guess == nums) {
				System.out.println("맞추셨습니다.");
				break;
			}else if (guess < nums) {
				System.out.println("추측한 숫자가 틀렸습니다.");
				System.out.println("추측한 숫자가 너무 작습니다.");
			}
			else {
				System.out.println("추측한 숫자가 틀렸습니다.");
				System.out.println("추측한 숫자가 너무 큽니다.");
			}
		}
		scanner.close();
		
		
		
		
	}
}
