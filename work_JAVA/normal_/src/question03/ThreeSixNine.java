package question03;

import java.util.Scanner;

public class ThreeSixNine {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("10~99사이의 정수를 입력하시오>> ");
		int num = scanner.nextInt();
		int num1 = num/10;
		int num2 = num %10;

		boolean First369 = (num1 ==3 || num1 == 6 || num1 == 9);
		boolean second369 = (num2 ==3 || num2 == 6 || num2 == 9);
//		int result = 0;
		
		if (First369 && second369) {
			System.out.println("박수짝짝");
		}else if (First369 || second369) {
			System.out.println("박수짝");
		}
		else {
			System.out.println(num);
		}
		scanner.close();
	}






}
