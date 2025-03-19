package question01;

import java.util.Scanner;

public class ExRectangle {
	public static void main(String[] args) {
		System.out.print("가로, 세로 길이를 입력하세요>>");
		
		Scanner scanner = new Scanner(System.in);
		
		int width = scanner.nextInt();
		int height = scanner.nextInt();
		
		int result = width*height;
		
		System.out.println("사각형의 면적은"+result+"입니다.");
		
		scanner.close();
				
	}
}
