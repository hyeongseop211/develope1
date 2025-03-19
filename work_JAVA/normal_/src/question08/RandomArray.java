package question08;

//import java.util.Random;
import java.util.Scanner;

public class RandomArray {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
//		Random random = new Random();
		
		System.out.print("정수 몇개? ");
		int n = scanner.nextInt();
		
		if (n>100 || n<=0) {
			System.out.println("1~100사이의 정수를 입력하세요");
			scanner.close();
			return;
		}
		
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = (int)(Math.random()*100)+1;
			
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(numbers[i]+ " ");
			if ((i+1)%10==0) {
				System.out.println();
			}
			scanner.close();
		}
	}
}
