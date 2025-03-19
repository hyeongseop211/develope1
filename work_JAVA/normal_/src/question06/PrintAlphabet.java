package question06;

import java.util.Scanner;

public class PrintAlphabet {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("소문자 알파벳 하나를 입력하시오>>");
//		문자열 첫번째 알파벳을 input에 저장
		char input = scanner.next().charAt(0);
		
//		i는 input에 저장된 알파벳과 같음
		/*
		 * 알파벳 'a' 까지 반복하며
		 * 한번 반복할때 마다 문자를 하나씩 감소(i--)
		 */
		for (char i = input; i >= 'a'; i--) {
			/*
			 * 'a'부터 시작해서 
			 * 바깥 for문의 현재 문자(i)까지 반복하며
			 * 한번 반복할 때 마다 문자를 하나씩 증가(j++)	
			 */
			for (char j = 'a'; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		scanner.close();
	}
}
