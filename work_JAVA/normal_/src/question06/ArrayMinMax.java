package question06;

import java.util.Scanner;

public class ArrayMinMax {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] num = new int [10];
		
//		양수 10개 받기
		System.out.println("양수 10개를 입력하세요.");
		
//		
		for (int i = 0; i < 10; i++) {
			num[i] = scanner.nextInt();
		}
		
//		최솟값과 최대값을 첫번째 입력 숫자로 지정
		int min = num[0];
		int max = num[0];
		
//		최솟값 최대값 지정하기
		for (int i = 1; i < num.length; i++) {
			if(num[i] < min) { min = num[i];}
			if(num[i] > max) {max = num[i];}
		}
		
		System.out.println("가장 작은 수는 "+min+"이고,가장 큰 수는 "+max+"이고,");
		System.out.println("최소값+최대값은 "+(min+max)+"입니다.");
		
		scanner.close();
	}
}
