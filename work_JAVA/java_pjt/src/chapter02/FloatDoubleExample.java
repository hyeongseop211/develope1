package chapter02;

public class FloatDoubleExample {
	public static void main(String[] args) {
//		오류 : 실수는 기본이 double
//		Type mismatch: cannot convert from double to float
//		float var1=3.14;
		float var1=3.14f;
		float var2=3.14F;
		double var3=3.14;
		
//		값을 저장시 오류발생하지 않고, 출력시 짤림
		float var4=0.1234567890123456789F;
//		소수점 자리수는 double > float
		double var5=0.1234567890123456789;
		
//		e6 = *10^6
		double var6=3e6;
		float var7=3e6f;
		float var8=2e-3f;
		double var9=2e-3;
		
		System.out.println("var1 : "+var1);
		System.out.println("var2 : "+var2);
		System.out.println("var3 : "+var3);
		System.out.println("var4 : "+var4);
		System.out.println("var5 : "+var5);
		System.out.println("var6 : "+var6);
		System.out.println("var7 : "+var7);
		System.out.println("var8 : "+var8);
		System.out.println("var9 : "+var9);
	}
}
