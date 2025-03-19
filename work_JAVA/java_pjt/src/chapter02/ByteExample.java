package chapter02;

public class ByteExample {
	public static void main(String[] args) {
//		byte var1=-128;
//		기본은 int 타입
//		Type mismatch: cannot convert from int to byte
//		범위 벗어나서 오류
//		byte var1=-129;
//		int var1=-129;
		byte var1=-128;
//		Duplicate local variable var1
//		byte var1=0;
		byte var2=0;
		byte var3=127;
//		Type mismatch: cannot convert from int to byte
//		byte var3=128;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
	}
}
