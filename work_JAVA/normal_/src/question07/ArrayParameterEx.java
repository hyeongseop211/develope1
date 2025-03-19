package question07;
/*
 * String[]사용
 * 메소드를 호출해서 문자열을 변경
 * to be or not to be -> to eat or not to eat
 */
// 배열의 모든 원소를 출력하는 메소드
public class ArrayParameterEx {
	public static void printStringArray(String[] arr) {
		for (String s : arr) {
			System.out.println(s+" ");
		}
		System.out.println();
	}
	
//	"be" 를 "eat" 으로 대체하는 메소드
	public static String replaceBe(String str) {
		return str.replace("be", "eat");
	}
	
	public static void main(String[] args) {
//		원본 문자열 배열 생성
		String[] quotes = {"to be or not to be"};
//		원본 출력
		printStringArray(quotes);
//		각 원소에서 "be"를 "eat" 으로 대체
		for (int i = 0; i < quotes.length; i++) {
			quotes[i] = replaceBe(quotes[i]);
		}
//		변경된 배열 출력
		printStringArray(quotes);
	}
}
