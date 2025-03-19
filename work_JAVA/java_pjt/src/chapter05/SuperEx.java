package chapter05;
/*
 * super()를 사용
 */
class Point2{
	private int x,y;// 4. (0,0)저장

	public Point2() {// 2. 슈퍼클래스 생성자 호출
		this.x = 0; this.y = 0;// 3. 멤버 저장
	}
	
	public Point2(int x, int y) {
		this.x = x; this.y = y;
	}
	public void showPoint() {
		System.out.println("("+x+","+y+")");
	}
}

class ColorPoint2 extends Point2{
	private String color;//6. blue 저장
	
	public ColorPoint2(int x, int y, String color) {// 1.(5,6,"blue")
		super(x,y); // a(5,6)
		this.color = color;//5. 멤버 저장
	}
	public void showColorPoint() {
		System.out.print(color);
		showPoint();
	}
}
public class SuperEx {
	public static void main(String[] args) {
//		객체 생성,(0,0), blue 셋팅
		ColorPoint2 cp = new ColorPoint2(5, 6, "blue");
		cp.showColorPoint();
	}
}










