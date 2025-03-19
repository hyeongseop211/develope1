package question03;

import java.util.Scanner;

public class DoWhileTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		int i =0;
		
		do {
			sum += i;
			i++;
		} while (i<=99);
		
		System.out.println("0부터 99까지의 합: "+sum);
		scanner.close();
	}


}
