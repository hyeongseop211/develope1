package chapter05;

//class Calculator{}
abstract class Calculator{// 추상클래스 선언(추상메소드는 없어도 됨)
//	public int add(int a, int b) {	return 1;	}
//	public abstract int add(int a, int b) {	return 1;	} // 추상메소드는 구현시 오류
	public abstract int add(int a, int b);// 추상메소드 선언
	public abstract int subtract(int a, int b); // 추상메소드 선언
	public abstract double average(int [] a); // 추상메소드 선언
}
//public abstract class GoodCalc extends Calculator{//추상클래스는 구현 불필요
public class GoodCalc extends Calculator{
	public static void main(String[] args) {
//		Cannot instantiate the type Calculator
//		Calculator calculator = new Calculator();
		GoodCalc c = new GoodCalc();
		System.out.println(c.add(2, 3));//5
		System.out.println(c.subtract(2, 3));//-1
		System.out.println(c.average(new int[] {2,3,4}));//3.0
	}

@Override // @ 는 이노테이션(시스템 주석) => 생략해도 문제 없음
public int add(int a, int b) {
	return a+b;
}

@Override
public int subtract(int a, int b) {
	return a-b;
}

@Override
public double average(int[] a) {
	double sum=0;
	for (int i = 0; i < a.length; i++) {
		sum+=a[i];
	}
	return sum/a.length;
}
}
