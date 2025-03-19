package question01;

import java.util.Scanner;

public class Median {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("정수 3개 입력>>");
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		int middle=0;
		
		if ((a>b && a<c)||(a>c && a<b)) {
			middle=a;
		}else if ((b>a && b<c)||(b>c && b<a)) {
			middle=b;
		}
		else {
			middle=c;
		}
		System.out.println("중간 값은"+middle);
	
		scanner.close();
	}
}
