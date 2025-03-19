package package11;

public class B {
	A a1=new A(true);
	A a2=new A(1);
//	private 접근지정자는 접근 안됨(자기 클래스만 가능)
//	default 접근지정자는 접근됨(같은 패키지)
	A a3=new A("문자열");
}
