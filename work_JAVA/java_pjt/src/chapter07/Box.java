package chapter07;

public class Box {
	private Object object;//홍길동, 777
	public Object get() {
		return object;
	}	
//	Object object="홍길동"  upcating
//	Object object=777  upcating
	public void set(Object object) {
		this.object = object;
	}
}
