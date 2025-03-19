package chapter07;

//T= TV, M = String
public class Product<T, M> {
	//T = TV, M =String
	private T kind;//3.new TV()
	private M model;//3. model = "스마트 TV"
	
	// T=TV 가 메소드의 리턴타입
	public T getKind() {
		return kind;
	}
	// T=TV 가 매개변수의 타입
	//1. TV kind = new TV()
	public void setKind(T kind) {
		this.kind = kind; //2.new TV()
	}
	// M=String 이 메소드의 리턴타입
	public M getModel() {
		return model;
	}
	//M=String 이 매개변수의 타입
	//1. String model
	public void setModel(M model) {
		this.model = model;//2.model = "스마트 TV"
	}
	
}
