package question09;

 class Clrcle1 {
    private double x, y;
    private double radius;
	public Clrcle1(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
    @Override
    public String toString() {
    	return "Circle("+x+","+y+")"+"반지름"+radius;
    }
    @Override
    public boolean equals(Object obj) {
    	Clrcle1 b=(Clrcle1) obj;
    	if (x == b.x && y==b.y) {
			return true;
		} else {
			return false;

		}
    }
    


}

public class CircleApp2  {
	public static void main(String[] args) {
		Clrcle a = new Clrcle(2, 3, 5);
		Clrcle b = new Clrcle(2, 3, 30);
		System.out.println("원 a : "+a);
		System.out.println("원 b : "+b);
		if (a.equals(b)) {
			System.out.println("같은 원");
		} else {
			System.out.println("서로 다른 원");

		}
	}
	

}
