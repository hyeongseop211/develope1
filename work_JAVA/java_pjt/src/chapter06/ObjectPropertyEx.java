package chapter06;

class Point{
	private int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
public class ObjectPropertyEx {
//	매개변수로 객체를 받는다.
	public static void print(Object obj) {// Object obj=new Point(2, 3)->업 캐스팅
//		실행중인 클래스
		System.out.println(obj.getClass());//class chapter06.Point
		System.out.println(obj.getClass().getName());//chapter06.Point
		System.out.println(obj.hashCode());//205125520 : 객체의 서면(10진수 해시코드)
		System.out.println(obj.toString());//chapter06.Point@c39f790 : 패키지.클래스@16진수 해시코드
		System.out.println(obj);//toString() 생략(문자열로 변환해서 출력)기본형?
	}
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		print(p);
	}
}
