package chapter13;

//람다식으로 구현할 함수형 인터페이스
interface MyFunction3{
	void print();
}
public class LambdaEx3 {
	public static void main(String[] args) {
		MyFunction3 f = ()->{System.out.println("Hello");};//람다식
		f.print();// 람다식 호출(람다식 객체에서 print 메소드 호출)
		
		f = ()->{System.out.println("안녕");};//람다식 재작성
		f.print();// 람다식 호출(람다식 객체에서 print 메소드 호출)
	}
}
