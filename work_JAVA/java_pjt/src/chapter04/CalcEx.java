package chapter04;

// default 접근 지정자
class Calc{
//	non static(인스턴스)멤버는 객체 생성해야 사용됨
//	public int abs(int a) {
	public static int abs(int a) {
		return a>0?a:-a;//절대값 반환
	}
	static int max(int a, int b) {
		return a>b?a:b;//둘중에 큰 수 반환
	}
	static int min(int a, int b) {
		return a>b?b:a;//둘중에 작은 수 반환
	}
}

//public: 접근 지정자(제한자)
public class CalcEx {
	public static void main(String[] args) {
//		static 멤버로서 객체 생성없이 접근 가능
		System.out.println(Calc.abs(-5));
		System.out.println(Calc.max(10,8));
		System.out.println(Calc.min(-3,-8));
	}
}
