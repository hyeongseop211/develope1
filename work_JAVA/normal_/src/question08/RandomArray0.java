package question08;

import java.util.Scanner;

public class RandomArray0 {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.print("정수 몇개? ");
		int n = scanner.nextInt();//ex>24
		int array[]=new int[n];//배열 크기가 24
		
		for (int i = 0; i < array.length; i++) {
			int r = (int)(Math.random()*100+1);//1~100까지의 난수를 발생
			array[i] = r;
			if (i == 0) {// 첫번째는 엔터 안침
				System.out.print(array[i]+ " ");
			} else {
				if (i%10 == 0) {// 10번째 마다 엔터
					System.out.println();
				}
				System.out.print(array[i]+ " ");

				}
			scanner.close();
			}
	}
}
