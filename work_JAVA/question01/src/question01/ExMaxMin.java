package question01;

import java.util.Scanner;

public class ExMaxMin {
	public static void main(String[] args) {
		System.out.print("정수 3개 입력>>");
		Scanner scanner=new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		int high=0;
		int low=0;
		
		if (a==b || b==c || c==a) {
			System.out.println("중복된값"); 
			return;
		
			}
		
		if (a>b && a>c) {
			high=a;
		}else if (b>a && b>c) {
			high=b;
		}
		else {
			high=c;
		}
		
		if (a<b && a<c) {
			low=a;
		}else if (b<a && b<c) {
			low=b;
		}
		else {
			low=c;
		}
		System.out.println("최대값은 "+high);
		System.out.println("최소값은 "+low);
		
		scanner.close();
	}
}
