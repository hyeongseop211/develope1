package question02;

import java.util.Scanner;

public class ArithmeticOperator {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int a = scanner.nextInt();
		
//		5000/3600=1
		int hour = a/3600;
		int minute = (a/60)%60;
		int second = a%60;
		
		
		
		System.out.println(a+"초는 "+hour+"시간, "+minute+"분, "+second+"초입니다.");
		scanner.close();
	}






}
