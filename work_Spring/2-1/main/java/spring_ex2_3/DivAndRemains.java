package spring_ex2_3;

public class DivAndRemains{
	private int num;

	public void process() {
		int ten=num/10;
		int one=num%10;
		if (ten == one) {
			System.out.println("10의 자리와 1의 자리가 같습니다.");
		} else {
			System.out.println("10의 자리와 1의 자리가 다릅니다.");

		}
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
