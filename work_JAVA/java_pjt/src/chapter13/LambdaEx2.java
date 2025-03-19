package chapter13;

//람다식으로 구현할 함수형 인터페이스
interface MyFunction2{
	int calc(int x);//람다식으로 구현할 추상 메소드
	
}
public class LambdaEx2 {
	public static void main(String[] args) {
//		MyFunction2 square = (x)->{return x*x;};//람다식
		MyFunction2 square = x->x*x;//람다식 매개변수 1개일때는 ()까지 생략가능
		System.out.println(square.calc(3));// 곱 구하기(람다식 객체에서 calc 메소드 호출)
		
	}
}
