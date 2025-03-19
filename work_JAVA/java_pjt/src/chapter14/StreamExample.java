package chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args)
	{
		//List 에, <> 괄호안은 제너릭 파라미터  -> Arrays.asList 리스트화
		List<Integer> numbers =  Arrays.asList(1,2,3,4,5,6,7,8);
		System.out.println("입력데이터 = " +numbers); //실행결과 [1,2,3,4,5,6,7,8]
		
//		<stream 적용해보자 >
		List<Integer> result =numbers.stream()//스트림 생성
			.filter(n->{return n%2 == 0;})//filter 메소드로 짝수만 추출(2,4,6,8)
			.map(n->{return n*n;}) //map 메소드로 제곱
			.collect(Collectors.toList()); //스트림 객체를 리스트로 변환(최종연산)
		System.out.println("실행결과 =" +result); //실행결과 = [4, 16, 36, 64]
	}


}
