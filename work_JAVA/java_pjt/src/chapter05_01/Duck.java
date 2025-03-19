package chapter05_01;

//public class Duck extends Bird{
public class Duck extends Bird implements Swim2, Fly{
//	public void swim() {
//		System.out.println("Ducks swim.");
//	}
//	public void fly() {
//		System.out.println("Ducks fly.");
//	}
	@Override
	public void swim() {
		System.out.println("Ducks swim.");
	}
	public void fly() {
		System.out.println("Ducks fly.");
	}
}
