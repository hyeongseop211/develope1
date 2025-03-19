package chapter04;

public class Book2 {
	String title; 
	String author;
	
	public Book2(String title, String a) {
		System.out.println("생성자1 호출됨");
//		매개변수를 this 자기자신의 객체 멤버로 저장
		this.title=title;
		author=a;
		
	}
	
	public Book2(String title) {
		this(title, "작자 미상");
		System.out.println("생성자2 호출됨");
//		this.title=title;
	}
	
	public Book2() {
		this("", "");
		System.out.println("생성자3 호출됨");
	}
	
	void show() {
		System.out.println(title+" "+author);
	}
	public static void main(String[] args) {
		Book2 littlePrince = new Book2("어린왕자","생텍쥐페리");
		Book2 loveStory = new Book2("춘향전"); 
		Book2 emptyBook = new Book2(); 
		
//		System.out.println(littlePrince.title+" "+littlePrince.author);
		littlePrince.show();
		loveStory.show();
		emptyBook.show();
	}
}
