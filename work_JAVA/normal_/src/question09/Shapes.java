package question09;

interface Shape{
	final double PI =3.14;
	void draw();
	double getArea();
	default public void redraw() {
		System.out.println("--- 다시 그립니다. ---");
		draw();
	}
}
class Circle implements Shape {
	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}
	public void draw() {
		System.out.println("반지름이 "+radius+"인 원입니다.");//오버라이딩 (동적 바인딩)
	}
	public double getArea() {
		return PI * radius * radius; // 오버라이딩 (동적 바인딩)
	}
}

public class Shapes {
	public static void main(String[] args) {
		Shape donut = new Circle(10);
		donut.redraw();
		System.out.println("면적은 "+donut.getArea());
	}
}
