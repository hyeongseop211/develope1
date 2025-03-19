package chapter02;

import java.util.Scanner;

/*
 * 커피 주문을 받아서 커피명과 가격을 출력
 */
public class CoffeePrice {
	public static void main(String[] args) {
		System.out.print("무슨 커피 드릴까요?");
		Scanner scanner=new Scanner(System.in);
//		next() : 문자열 입력받는 메소드
		String order = scanner.next();
//		커피가격 변수 선언
//		초기값 없을시 오류
//		int price;
		int price=0;
		
		switch (order) {
		case "에스프레소":
		case "카푸치노":
		case "카페라떼":
			price=3500;
			break;
		case "아메리카노":
			price=2000;
			break;

		default:
			System.out.println("메뉴에 없습니다!");
			break;
		}
		if (price!=0) {
			System.out.println(order+"는 "+price+"원입니다.");
		}
//		The local variable price may not have been initialized(int 초기값 없음)
//		System.out.println(order+"는 "+price+"원입니다.");
		
		scanner.close();
	}
}
