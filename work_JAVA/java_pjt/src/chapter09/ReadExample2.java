package chapter09;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:\\temp\\test.txt "); 
		int readByte;
		byte[] readBytes = new byte[3];
		String data = "";
		
		while (true) {
//			readByte = is.read();//1바이트 단위로 읽는다.(정수로 받음): ex> 호미
			readByte = is.read(readBytes);//3바이트 단위로 읽는다.(정수로 받음): ex> 삽
			if (readByte == -1) {
				break;
			}
//			문자3개를 형변환하면서 오류 ex>aaa -> char
//			System.out.print((char)readByte);
			data += new String(readBytes, 0, readByte);
		}
		System.out.println(data);
		is.close();
	}
}
