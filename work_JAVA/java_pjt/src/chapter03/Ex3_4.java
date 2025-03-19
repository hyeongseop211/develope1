package chapter03;

public class Ex3_4 {
	public static void main(String[] args) {
//		String 타입의 names 배열 선언
//		String[] names;
//		배열 선언, 생성, 초기화
//		배열 원소(값)이 4개면 인덱스는 0~3까지 
//		String[] names= {"Sam","Kate","John","Jenny"};
//		String 배열 객체 생성
//		String 기본값: null
//		String[] names= new String[4];
//		String[] names; // 배열 선언
//		names=new String[4]; // 배열 생성
//		0번째 인덱스에 aaa 문자열 값(원소)를 할당
//		names [0]="aaa";
//		double[] names;
//		double 기본값 : 0.0
//		names = new double[4];
//		배열 선언, 생성
//		int 기본값 : 0
		int[] names = new int[4];
		
//		[Ljava.lang.String;@1bc6a36e => 참조변수의 값
//		System.out.println(names);
//		선언만 했을 경우 오류 발생
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		System.out.println(names[3]);
	}
}
