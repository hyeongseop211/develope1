package chapter05_01;

public class Main {
	public static void main(String[] args) {
//		new Animal(); // 추상클래스는 객체 생성 못함
		Animal a;//참조변수 선언은 된다.
		Penguin p = new Penguin();
		p.swim();// 멤버 5개 (life,wing,walk,eat,swim)중 수영한다,
		
		Bird p2 = new Penguin();//upcasting
//		p2.swim();//업캐스팅은 슈퍼클래스의 멤버만 접근 가능(오류 발생)
		p2.walk();
		Penguin p3 = (Penguin) p2;//다운캐스팅
		p3.swim();// 다운캐스팅은 모든 멤버 접근 가능
		
		Bird d = new Duck();//업캐스팅
		d.eat();//업캐스팅은 슈퍼클래스의 멤버만 접근 가능
		Duck d2 = (Duck) d;// 다운캐스팅
		d2.fly();//  다운캐스팅은 모든 멤버 접근 가능
		
//		추상클래스를 참조변수 선언(슈퍼클래스)
		Animal d3 = new Duck();//업캐스팅은 슈퍼클래스의 멤버만 접근 가능
		int x = d3.life;
		System.out.println("x=>"+x);
		
//		new Swim2(); :인터페이스는 객체 생성 못함
		Swim2 s = new Penguin();//인터페이스를 참조변수 선언
		s.swim();//penguins swim.
		
		// 인터페이스가 인터페이스 배열 2개를 가리킨다.
		//객체배열과 형태가 비슷
		//s2[0],s2[1]
		Swim2[] s2 = new Swim2[2];
		s2[0] = new Penguin();//s2[0] : 참조변수
		s2[1] = new Duck();//s2[0] : 참조변수
		s2[0].swim();//penguins swim
		s2[1].swim();//Ducks swim
//		Java.Lang.ArrayInsexOutOfBoundsException
		s2[2] = new Penguin(); // 오류
	}
}
