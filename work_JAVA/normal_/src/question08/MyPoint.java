package question08;

class MyPoint {
	private int x, y;
	
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean equals(MyPoint p) {
		if (x==p.x && y==p.y) {
		return true;
		} else {
		return false;
		}
	
}


	@Override
public String toString() {
	return "Point (" + x + "," + y + ")";
}
	public static void main(String[] args) {
		MyPoint p = new MyPoint(3, 50);
		MyPoint q = new MyPoint(4, 50);
		System.out.println(p);
		if (p.equals(q)) System.out.println("같은 점"); 
		else System.out.println("다른 점");

		
	}
}
