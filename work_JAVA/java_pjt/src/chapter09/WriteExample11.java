package chapter09;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample11 {
	public static void main(String[] args) throws Exception {
//		Writer : 문자 단위 출력을 위한 최상위 스트링 클래스
//		FileWriter : 문자 단위 출력을 위한 하위 스트링 클래스
		Writer writer = new FileWriter("C:/temp/output11.txt");// upcasting
//		문자열을 문자 하나씩 배열로 가져온다.
		char[] data = "홍길동".toCharArray();
		
		for (int i = 0; i < data.length; i++) {
			writer.write(data[i]);
		}
		
		writer.close();
	}
}
