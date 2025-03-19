package chapter09;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample12 {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("C:/temp/output12.txt");// upcasting
		char[] data = "홍길동2".toCharArray();
		writer.write(data);
		
//		for (int i = 0; i < data.length; i++) {
//			writer.write(data[i]);
//		}
		
		writer.close();
	}
}
