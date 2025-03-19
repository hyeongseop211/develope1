package chapter14;

import java.util.Arrays;

public class MainTest1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int sumValue = Arrays.stream(arr).sum();// sum() 배열요소의 합
		long count = Arrays.stream(arr).count();// count() 배열 요소의 개수
		
		System.out.println(sumValue);
		System.out.println(count);
	}
}
