package question09;

class TV2{
	private int size;
	private int color;
	
	public TV2(int size, int color) {
		this.size = size;
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public int getColor() {
		return color;
	}

}


class IPTV extends TV2 {
	private String ip;
	
	
	public IPTV(String ip,int size,int color ) {
		super(size, color);
		this.ip = ip;
	}
	public void Print() {
		System.out.println("나의 IPTV는 "+ip+" 주소의 "+getSize()+"인치 "+getColor()+"컬러");
	}


	public static void main(String[] args) {
		IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
		iptv.Print();
	}
}
