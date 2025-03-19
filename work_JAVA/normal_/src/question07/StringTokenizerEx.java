package question07;

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		String text = "홍길동/장화/홍련/콩쥐/팥쥐";
		
//		문자열을 '/' 구분자로 분리
		StringTokenizer st = new StringTokenizer(text, "/");
		
//		각 토큰을 카테고리별로 저장할 StringBuilder 객체들
		StringBuilder fairyTale = new StringBuilder("동화 : ");
		StringBuilder realPerson = new StringBuilder("실존인물 : ");
		
//		토큰을 순회하며 분류
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			
//			동화 속 인물인 경우
			if (token.equals("장화") || token.equals("홍련") || token.equals("콩쥐") || token.equals("팥쥐")) {
				fairyTale.append(token).append(" ");
			}
//			실존 인물인 경우
			else if (token.equals("홍길동")) {
				realPerson.append(token).append(" ");
			}
		}
//		 결과 출력
		System.out.println(fairyTale.toString().trim());
		System.out.println(realPerson.toString().trim());
	}
}
