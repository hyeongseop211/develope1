package chapter03;


/*
 * do while 문
 * a~z 알파벳 소문자 출력
 * 
 */
public class DoWhileSample {
	public static void main(String[] args) {
		char c='a';
		
		do {
//			알파벳 출력
			System.out.print(c);
//			c+1 => 문자+정수=정수
//			유니코드 변환해서 1증가한 유니코드가 문자로 변환해서 변수 c에 저장
//			c=(char)(c+1);
//			c=c+1;//오류
			c+=1;//c=c+1 // 자동변환
//			c++;
		} while (c <= 'z');
	}
}
