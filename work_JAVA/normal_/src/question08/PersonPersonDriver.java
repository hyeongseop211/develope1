package question08;

import java.util.Scanner;

 class Person {
	private String fName;
	private String lName;
	
	public Person(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}

	public String getFirstName() {
		return fName;
	}
	public String getLastName() {
		return lName;
	}
	public int getLength() {
		return (fName + lName).length();
	}
	
	
}

public class PersonPersonDriver {
	public static void main(String[] args) {
		String fname;
		String lname;
		Scanner scanner = new Scanner(System.in);
		
		Person person1, person2;
		
		System.out.print("성을 입력하세요 : ");
		lname = scanner.next();
		
		System.out.print("이름을 입력하세요 : ");
		fname = scanner.next();
		
		person1 = new Person(fname, lname);
		System.out.println("성: "+person1.getLastName()+" "+"이름 : "+person1.getFirstName()+" "+"성명의 길이 : "+person1.getLength());
		
		System.out.print("성을 입력하세요 : ");
		lname = scanner.next();
		
		System.out.print("이름을 입력하세요 : ");
		fname = scanner.next();
		
		person2 = new Person(fname, lname);
		
		System.out.println("성: "+person2.getLastName()+" "+"이름 : "+person2.getFirstName()+" "+"성명의 길이 : "+person2.getLength());
		
		scanner.close();
	}
}











