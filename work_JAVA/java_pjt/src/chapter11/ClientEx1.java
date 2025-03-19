package chapter11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {
	public static void main(String[] args) {
		Socket socket = null;//클라이언트 소켓 선언
		BufferedReader in = null;//입력: 클라이언트에서 들어오는 데이터
		BufferedWriter out = null;//출력: 서버에서 보내는 데이터
		Scanner scanner = new Scanner(System.in);
		
		
		try {
			//소켓 객체로 데이터를 주고 받음
			//서버 ip와 포트를 가지고 소켓 객체 생성
			socket = new Socket("localhost",9999);
			//입력: 클라이언트에서 들어오는 데이터
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//출력: 서버에서 보내는 데이터
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while (true) {
				System.out.print("보내기>>");
				String outputMessage = scanner.nextLine();//서버에서 보내는 메세지
				if (outputMessage.equals("bye")) {//클라이언트의 메세지가 bye 일때
					out.write(outputMessage+"\n");//서버로 메세지 보내기
					out.flush();//비정상적인 종료일때 메세지 재전송
					break;
				}
				out.write(outputMessage+"\n");//서버로 메세지 보내기
				out.flush();//비정상적인 종료일때 메세지 재전송
				String inputMessage = in.readLine();//한 행의 문자열을 읽는다.
				System.out.println("서버: "+inputMessage);//서버에서 온 메세지
			}
			
		} catch (Exception e) {
			e.printStackTrace();//예외처리시 시스템에서 자동으로 출력되는 메세홏지
		} finally {
//			자원 반납(예외발생까지 고려)
			try {
				scanner.close();
				socket.close();
			} catch (Exception e2) {//서버와 클라이언트 간에 입출력시 예외 발생
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
			}
		}
	}
}
