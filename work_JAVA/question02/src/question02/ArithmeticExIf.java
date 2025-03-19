package question02;

import java.util.Scanner;

public class ArithmeticExIf {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("연산 >>");
		int num1 = scanner.nextInt();
		String operator = scanner.next();
		int num2 = scanner.nextInt();
		
		int result = 0;
		
		if (operator.equals("+")) {
			result = num1 + num2;
		}else if (operator.equals("-")) {
			result = num1 - num2;
		}else if (operator.equals("*")) {
			result = num1 * num2;
		}else if (operator.equals("/")) {
			if (num2 == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				scanner.close();
				return;
			}
			result = num1 / num2;
		}
		System.out.println(num1 + " "+operator+" "+num2+" = "+result);
		
		scanner.close();
	}
}
