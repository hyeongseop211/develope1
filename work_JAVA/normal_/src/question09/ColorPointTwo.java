package question09;

class cPoint {
//	protected int x,y;
	private int x,y;

	public cPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	protected void move(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
}

public class ColorPointTwo extends cPoint{
	private String color;
	
	public ColorPointTwo(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	public void setXY(int x, int y) {
		move(x,y);
	}
	
	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public String toString() {
		return color +"색의 "+"("+getX()+","+getY()+")의 점";
	}

	public static void main(String[] args) {
		ColorPointTwo zeropoint = new ColorPointTwo(0, 0, "BLACK");
		ColorPointTwo cp = new ColorPointTwo(5, 5, "YELLOW");
		System.out.println(zeropoint.toString()+"입니다.");
		cp.setXY(5, 5);
		cp.setColor("RED");
//		String str = cp.toString();
		System.out.println(cp.toString()+"입니다.");
	}

}
