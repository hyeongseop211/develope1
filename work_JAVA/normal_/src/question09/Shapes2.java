package question09;

interface Shape2{
	final double PI =3.14;
	void draw();
	double getArea();
	default public void redraw() {
		System.out.print("--- 다시 그립니다. ---");
		draw();
	}
}
class Circle2 implements Shape2 {
	private int radius;

	public Circle2(int radius) {
		this.radius = radius;
	}
	public void draw() {
		System.out.println("반지름이 "+radius+"인 원입니다.");//오버라이딩 (동적 바인딩)
	}
	public double getArea() {
		return PI * radius * radius; // 오버라이딩 (동적 바인딩)
	}
}
class Oval implements Shape2 {
	private int width, height;

	public Oval(int width, int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public void draw() {
		System.out.println(width+"x"+height+"에 내접하는 타원 입니다");
	}
	public double getArea() {
		return PI*width*height;
	}
}
class Rect implements Shape2 {
	private int width,height;

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public void draw() {
		System.out.println(width+"x"+height+"크기의 사각형 입니다.");
	}
	public double getArea() {
		return width*height;
	}
	
}


public abstract class Shapes2 implements Shape2{
	public static void main(String[] args) {
		Shape2[] list = new Shape2[3];
		list[0] = new Circle2(10);
		list[1] = new Oval(20, 30);
		list[2] = new Rect(10, 40);
		
		for (int i = 0; i < list.length; i++) 
			list[i].redraw();
		for (int i = 0; i < list.length; i++) {
			System.out.println("면적은 "+list[i].getArea());
			
		}
	}
}
