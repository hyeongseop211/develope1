package question03;

import java.util.Scanner;

public class ContinueSamYukGu {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		for (int i = 1; i <=10; i++) {
			if (i%3==0) {
				System.out.print("짝 ");
				continue;
			}
				System.out.print(i+" ");
			
			
//			if (i%3==0) {
//				System.out.print("짝 ");
//			} else {
//				System.out.print(i+" ");
//			}
			
		}
		scanner.close();
	}








}
