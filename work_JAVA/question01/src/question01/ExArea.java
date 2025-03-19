package question01;

import java.util.Scanner;

public class ExArea {
	public static void main(String[] args) {
		System.out.print("정수를 입력하시오>>");
		Scanner scanner=new Scanner(System.in);
		
		double a=scanner.nextDouble();
		double b=scanner.nextDouble();
		double c=scanner.nextDouble();
		double result1=(a*b)/2;
		double result2=(a+b)*c/2;
		
		if (c == 0) {
			System.out.println("삼각형의 넓이는 "+result1);
		} else {
			System.out.println("사다리꼴의 넓이는 "+result2);

		}
		scanner.close();
	}
}
