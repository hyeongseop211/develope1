package chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainTest2 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		Stream<Integer> myStream = list.stream();// 스트림 생성
//		중간 연산이 filter 나 map
		myStream.filter(s->(s>=5)).forEach(n->System.out.println(n));
		
//		스트림 연산을 하더라도 list 원 데이터는 변하지 않음
		System.out.println(list);
	}
}
