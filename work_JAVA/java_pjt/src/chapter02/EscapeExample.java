package chapter02;

public class EscapeExample {
	public static void main(String[] args) {
		System.out.println("번호이름직업");
//		\t :탭만큼 띄움
//		print: 엔터 적용안됨
//		System.out.print("번호\t이름\t직업");
//		\n : 엔터(다음행)
		System.out.print("번호\t이름\t직업\n");
//		println : 엔터 적용
		System.out.println("번호\t이름\t직업");
		System.out.print("번호\t이름\t직업");
		System.out.println();// 엔터
//		System.out.print("번호\t이름\t직업");
//		\ + 특수문자 => 특수문자 사용가능 
		System.out.println("우리는 \"개발자\" 입니다.");
		System.out.println("봄여름가을겨울");
		System.out.println("봄\\여름\\가을\\겨울");
		
	}
}
