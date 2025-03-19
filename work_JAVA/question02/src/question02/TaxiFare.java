package question02;

public class TaxiFare {
	public static void main(String[] args) {
		int fare = 0;
		int income = 0;
		int i=1;
		
		while (i<=10) {
			fare=i*1000;
			income+=(i*1000);
			i++;
			System.out.println("요금을 입력하세요 : "+fare);
		}
		System.out.println("총수입 : "+income);
	}
}
