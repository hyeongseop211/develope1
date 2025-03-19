package chapter10;

public class TimerThread extends Thread{
	int n=0;
	public void run() {
		while (true) {
			System.out.println(n);
			n++;
			try {
				sleep(1000);//1초마다 실행
//				예외 발생할때 e로 catch 해서
			} catch (InterruptedException e) {
//				printStackTrace 메소드로 예외 처리 기본 메시지를 출력
				e.printStackTrace();
			}
			
		}
	}
}
