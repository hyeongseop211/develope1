package question03;

import java.util.Scanner;

public class ForSample {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <11; i++) {
			sum += i;
			System.out.print(i);
			if(i<=9) {
				System.out.print("+");
			}
			
		}
		System.out.print("="+sum);
		scanner.close();
	}



}
