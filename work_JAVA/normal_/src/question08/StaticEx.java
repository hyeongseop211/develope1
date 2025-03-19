package question08;

class ArrayUtil {
	public static int [] concat(int[] a, int[] b) {
		int c[] = new int[a.length + b.length]; // 새 배열 생성
        for(int i=0; i<a.length; i++) { // 첫 번째 배열 복사
            c[i] = a[i];
        }
        for(int i=0; i<b.length; i++) {// 두 번째 배열 복사
            c[a.length + i] = b[i];
        }
        return c;
	}
	public static void print(int[] a) {
		for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
	}
}
public class StaticEx {
	public static void main(String[] args) {
		int [] array1 = {1,5,7,9}; //첫 번째 배열
		int [] array2 = {3,6,-1,100,77}; // 두 번째 배열
		int [] array3 = ArrayUtil.concat(array1, array2);// 배열 합치기
		System.out.print("[ ");
		ArrayUtil.print(array3);// 결과출력
		System.out.print("]");
	}
}
