package chapter12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class arraysTest2 {
	public static void main(String[] args) {
		String[] a = {"a","b","c","d"};
		int[] b = {1,5,5,7,3,3,42,6,8,45323,4,63,2,1};
		System.out.println(a);// 배열객체 출력
		System.out.println(Arrays.asList(a));//List 로
		List<String> list = Arrays.asList(a);
		System.out.println("@# list.get(0)=> "+list.get(0));
		
		Arrays.sort(b, 4, 14);//인덱스 정렬(4~13)
		System.out.println(Arrays.toString(b));//String 으로
//		[1, 5, 5, 7, 1, 2, 3, 3, 4, 6, 8, 42, 63, 45323]
		Arrays.sort(b);// 오름차순 정렬
		System.out.println(Arrays.toString(b));//String 으로
//		[1, 1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 42, 63, 45323]
		
		Arrays.sort(a, Collections.reverseOrder());// 문자열 배열을 내림차순
		System.out.println(Arrays.toString(a));
//		[d, c, b, a]
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
//		[a, b, c, d]
		
		Arrays.sort(a,2,4,Collections.reverseOrder());
		System.out.println(Arrays.toString(a));
//		[a, b, d, c]
		
		String[] cc= {"11","12","13","23","53","223","145","53"};
		Arrays.sort(cc,Collections.reverseOrder());
		System.out.println(Arrays.toString(cc));
//		[53, 53, 23, 223, 145, 13, 12, 11]
		
		int[] c = Arrays.copyOf(b, b.length);// 배열객체를 복사
		System.out.println(Arrays.toString(c));// String으로
//		[1, 1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 42, 63, 45323]
		
		String[] d = Arrays.copyOf(a, 3);// a배열 객체를 크기 3인 배열로 복사
		System.out.println(Arrays.toString(d));
//		[a, b, d]
		System.out.println(Arrays.toString(a));
//		[a, b, d, c]
	}
}












