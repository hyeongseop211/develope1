package question06;

public class RandomTen1 {
	public static void main(String[] args) {
		int n[]=new int[10];
		int sum=0;
		
		for (int i = 0; i < n.length; i++) {
			int r = (int)(Math.random()*10)+1;
				n[i]=r;
				sum+=n[i];
		}
		System.out.print("랜덤한 정수들 : ");
		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i]+" ");
		}
		System.out.println("\n평균은 "+(double)sum/n.length);
	}
}
