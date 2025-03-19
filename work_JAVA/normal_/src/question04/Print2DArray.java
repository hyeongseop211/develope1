package question04;


public class Print2DArray {
	public static void main(String[] args) {
//		열의 크기가 각각 달라서 비정방형 배열
		int n [][] = { {1}, {1,2,3}, {1}, {1,2,3,4}, {1,2}};
		
//		n.length : 5(행의 크기) => 중괄호 안에 중괄호 갯수
		for (int i = 0; i < n.length; i++) {
//				n[0].length=1;
//				n[1].length=3;
//				n[2].length=1;
//				n[3].length=4;
//				n[4].length=2;
			for (int j = 0; j < n[i].length; j++) {
//				n[i][j] : 2차원 배열원소
				System.out.print(n[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
