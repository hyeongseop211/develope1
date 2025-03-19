package chapter05;

/*
 * instanceof 연산자 사용(상속)
 */
class Person{}
class Student extends Person{}
class Researcher extends Person{}
class Professor extends Researcher{}
public class InstanceOfEx {
	// Person p = new Student() -> 업캐스팅
	static void print(Person p) {
		if (p instanceof Person) {// p 객체가 Person 클래스 타입인지
			System.out.print("Person ");// 참이면 출력
		}
		if (p instanceof Student) {// p 객체가 Student 클래스 타입인지
			System.out.print("Student ");// 참이면 출력
		}
		if (p instanceof Researcher) {// p 객체가 Researcher 클래스 타입인지
			System.out.print("Researcher ");// 참이면 출력
		}
		if (p instanceof Professor) {// p 객체가 Professor 클래스 타입인지
			System.out.print("Professor ");// 참이면 출력
		}
		System.out.println();
	}
	public static void main(String[] args) {
		System.out.print("new Student() -> \t"); print(new Student()); // Person Student
		System.out.print("new Researcher() -> \t"); print(new Researcher()); // Person Student
		System.out.print("new Professor() ->\t"); print(new Professor()); // Person Student
	}
}
