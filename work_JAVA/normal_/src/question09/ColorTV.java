package question09;

class TV { 
	private int size;
	public TV(int size) {this.size = size;}//단축키 생성가능
	protected int getSize() {return size;}//단축키 생성가능
}

class ColorTV extends TV{
	private int color;

	public ColorTV(int size, int color) {
		super(size);
		this.color = color;
	}
	public void printProperty() {
		System.out.println(getSize()+"인치 "+color+"컬러");
	}
	


	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
	}
}