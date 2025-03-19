package chapter07;

//대문자 알파벳T를 타입파라미터로 받은 제네릭
public class Box2<T> {//T가 String, Integer
//	T가 String
	//3.hello
	private T t;// 타입파라미터를 t의 타입으로 사용

	//타입파라미터를 메소드의 리턴타입으로 사용
//	T가 String, Integer
	public T get() {
		return t;
	}
//	T가 String, Integer
	//타입파라미터를 메소드의 매개변수 타입으로 사용
	public void set(T t) {//1.hello
		this.t = t;//2.hello
	}
	
	
}
