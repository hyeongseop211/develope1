package question06;

import java.util.Random;

/*
 * 난수를 발생 Math(클래스), Random(클래스)
 */
public class RandomNumber {
	public static void main(String[] args) {
		int rNumber;
		Random generator = new Random();
		while (true) {
			rNumber = generator.nextInt(10)+1;
			
			System.out.println(rNumber);
			if (rNumber==7) {
				System.out.println("============");
				break;
			}
			
		}
		
		
		
		/*
		generator.nextInt();// 난수 발생(범위 : int 타입 범위-> 2의 31승~2의 31승-1)
		generator.nextInt(10);// 난수 발생(0~9의 정수)
//		int a = generator.nextInt(10)+1;// 난수 발생(0~10의 정수)
//		double범위 .nextFloat() float 범위 .nextLong(); long타입 범위 .nextBoolean(); 참/거짓
		generator.nextDouble();
		*/
	}
}
