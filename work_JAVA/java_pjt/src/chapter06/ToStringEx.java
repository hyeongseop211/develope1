package chapter06;

class Point2{
	private int x,y;
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point2("+x+","+y+")";
	}
}
public class ToStringEx {


	public static void main(String[] args) {
		Point2 p = new Point2(2, 3);
		System.out.println(p);//chapter06.Point2@c39f790 : 패키지.클래스.16진수 해시코드
		System.out.println(p.toString());//chapter06.Point2@c39f790 : 패키지.클래스.16진수 해시코드
		System.out.println(p.toString()+"입니다.");//chapter06.Point2@c39f790 : 패키지.클래스.16진수 해시코드
	}
}
