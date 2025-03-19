package question04;

public class CoronaSum {
	public static void main(String[] args) {
		int[][] corona = new int[12][3];
		int totalsum = 0;
		
		corona[0][0] = 11;
		corona[0][1] = 12;
		corona[0][2] = 13;
		
		for (int i = 1; i < 12; i++) {
			corona[i][0] = (i+1)*10+1;
			corona[i][1] = (i+1)*10+2;
			corona[i][2] = (i+1)*10+3;
		}
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 3; j++) {
				totalsum += corona[i][j];
			}
		}
		System.out.println("1년 전체 코로나 환자수는 "+totalsum);
		
	}
}









