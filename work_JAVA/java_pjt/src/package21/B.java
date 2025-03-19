package package21;

public class B {
	public static void main(String[] args) {
		A a=new A();
//		private 멤버는 자기 클래스 안에서만 접근됨
		a.field1=2;
		a.field2=2;
		
		a.method1();
		a.method2();
	}
	
}
