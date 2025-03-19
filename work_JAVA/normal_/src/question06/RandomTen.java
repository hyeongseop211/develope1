package question06;

import java.util.Random;

public class RandomTen {
	public static void main(String[] args) {
		int[] nums = new int[10];
		
		Random random = new Random();
		
		System.out.print("랜덤한 정수들 :");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(10)+1;
			
			System.out.print(nums[i]+" ");
			System.out.println();
			
		}
		double sum = 0;
		for (int number : nums) {
			sum += number;
		}
		double avg = sum/nums.length;
		
		System.out.print("평균은 "+avg);
	}
}
