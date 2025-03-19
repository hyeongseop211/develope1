package chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample2 {
	public static void main(String[] args)
	{
		//List 에, <> 괄호안은 제너릭 파라미터  -> Arrays.asList 리스트화
		List<String> words =  Arrays.asList("Java","Stream","Library");
		System.out.println("입력데이터 = " +words); //실행결과 [1,2,3,4,5,6,7,8]
		
		List<Integer> result =words.stream()//스트림 생성
			.map(String::length) //메소드 참조로 문자열 길이 구함
			.collect(Collectors.toList());
		System.out.println("실행결과 =" +result); //실행결과 =[4, 6, 7]
	}


}
