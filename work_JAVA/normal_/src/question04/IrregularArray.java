package question04;

public class IrregularArray {
	public static void main(String[] args) {
		// 비정방형 배열 : 행만 정의하고 열은 비워둠
		int[][] array = new int[4][];
		
		
		array[0] = new int[3];// 1행 열의 크기는 3
		array[1] = new int[2];// 2행 열의 크기는 2
		array[2] = new int[3];
		array[3] = new int[2];
		
		array[0][0] = 10; array[0][1] = 11; array[0][2]=12;
		array[1][0] = 20; array[1][1] = 21;
		array[2][0] = 30; array[2][1] = 31; array[2][2]=32;
		array[3][0] = 40; array[3][1] = 41; 
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
}
