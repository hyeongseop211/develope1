package question09;

class PointThree {
	protected int x;
	protected int y;

	public PointThree(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(int x,int y) {
		this.x =x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
}
class Point3D extends PointThree {
	private int z;
	
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	public void moveUp() {
		z++;
	}
	public void moveDown() {
		z--;
	}
	public void move(int x,int y, int z) {
		this.z = z;
	}
	@Override
	public String toString() {
		return "("+x+","+y+","+z+")";
	}
	public static void main(String[] args) {
		Point3D p = new Point3D(1, 2, 3);
		System.out.println(p.toString()+"의 점입니다.");
		
		p.moveUp();
		System.out.println(p.toString() + "의 점입니다.");
		
		p.moveDown();
		p.move(10, 10);
		System.out.println(p.toString()+"의 점입니다.");
		
		p.move(100, 200, 300);
		System.out.println(p.toString()+"의 점입니다.");
	}


}
