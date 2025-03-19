package question09;

 class Clrcle {
    private double x, y;
    private double radius;
    
    public Clrcle(double x, double y, double radius) {
        setX(x);
        setY(y);
        setRadius(radius);
    }
    
    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }
    
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setRadius(double radius) { this.radius = radius; }
    
    public boolean equals(Clrcle c) {
        return this.getX() == c.getX() && this.getY() == c.getY();
    }
    
    public String toString() {
        return "Circle(" + getX() + "," + getY() + ")반지름" + getRadius();
    }


}

public class CircleApp  {
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
