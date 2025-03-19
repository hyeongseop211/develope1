package chapter02;

/*
 * 작성일 : 2025-02-12 
 * 작성자 : 홍길동
 * 내용 	: HelloWorld 클래스로 문자열 출력
 */
//jvm: 자바가상기계
//jvm -> public class 메소드를 찾아감 1번
//jvm -> main 메소드를 찾아감 2번
public class HelloWorld {
	public static void main(String[] args) {
//		String : 문자열 타입
		// message : 변수 명
//		String message;//변수 선언
//		message = "헬로 월드!"; // 변수값 할당
		String message = "헬로 월드!";//변수 선언+초기화
		System.out.println(message);
		message = "헬로 투헬!"; // 변수값 할당
		System.out.println(message);
	}
}
