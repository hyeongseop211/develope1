package chapter04;

public class ArrayParameterEx {
//	공백을 쉽표로 바꾸는 메소드
	static void replaceSpace(char a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == ' ') {
				a[i]=',';
			}
		}
	}
	static void PrintCharArray(char a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			
		}
		System.out.println();
	}
	public static void main(String[] args) {
		char c[]= {'T','h','i','s',' ','i','s',' ','a',' ','p','e','n','c','i','l'};
		
		PrintCharArray(c);
		replaceSpace(c);
		PrintCharArray(c);
	}
}
