package question09;

class PointFour{
	private int x,y;
	
	public PointFour() {
		this.x=0;
		this.y=0;
	}
	public PointFour(int x, int y) {
		this.x = x;
		this.y = y;
	}
	protected void move(int x, int y) {
		this.x=x;
		this.y=y;
	}
//	public int getX() {
//		return x;
//	}
//	public int getY() {
//		return y;
//	}
	@Override
	public String toString() {
		return "("+x+","+y+")의 점";
	}
}

public class PositivePoint extends PointFour{

	public PositivePoint() {
		super();
	}
	public PositivePoint(int x, int y) {
		super(x>0? x:0, y>0 ? y:0);
	}
	public void move(int x, int y) {
		if(x>0 && y>0) {
			super.move(x, y);
		}
	}
	public static void main(String[] args) {
		PositivePoint p = new PositivePoint();
		p.move(10, 10);
		System.out.println(p.toString()+"입니다.");
		
		p.move(-5, -5);
		System.out.println(p.toString()+"입니다.");
		
		PositivePoint p2 = new PositivePoint(-10,-10);
		System.out.println(p2.toString()+"입니다.");
	}
}
