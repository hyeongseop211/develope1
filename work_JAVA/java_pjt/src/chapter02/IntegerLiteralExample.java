package chapter02;

public class IntegerLiteralExample {
	public static void main(String[] args) {
		// 0b~ : 이진수
//		1*2의3승 + 0*2의2승 + 1*2의1승 + 1*2의0승
		int var1=0b1011;
//		0~ : 8진수
//		2*8의2승 + 0*8의1승 + 6*8의0승
		int var2=0206;
		int var3=365;
//		0x~ : 16진수
//		B*16의1승 + 3*16의0승
		int var4=0xB3;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
	}
}
