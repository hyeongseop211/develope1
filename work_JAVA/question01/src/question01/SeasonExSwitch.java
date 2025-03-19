package question01;

import java.util.Scanner;

public class SeasonExSwitch {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("달을 입력하세요(1~12)>>");
		String name;
	
		int month = scanner.nextInt();
		
		switch (month) {
		case 3,4,5:
			name="봄";
			break;
		case 6,7,8:
			name="여름";
		break;
		case 9,10,11:
			name="가을";
		break;
		case 1,2:
		case 12:
			name="겨울";
		break;

		default:
			name="잘못입력";
			break;
		}
		System.out.println(name);
		scanner.close();
	}


}
