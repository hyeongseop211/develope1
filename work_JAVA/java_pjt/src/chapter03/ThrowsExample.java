package chapter03;

public class ThrowsExample {
	public static void main(String[] args) {
		try {
			findClass();
			System.out.println("클래스를 찾음!!!");
		} catch (Exception e) {
			System.out.println("클래스를 못찾음");
		}
	}
	
//	throws : 메소드 호출한 곳으로 예외처리를 넘김
	public static void findClass() throws ClassNotFoundException{
//		public static void findClass() {
		Class.forName("java.lang.String");
//		Class.forName("java.lang.String2");
		
			/*
		try {
//			Class.forName("java.lang.String");
			Class.forName("java.lang.String2");
			System.out.println("클래스를 찾음2!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 못찾음2");
		}
		*/
	}
}
