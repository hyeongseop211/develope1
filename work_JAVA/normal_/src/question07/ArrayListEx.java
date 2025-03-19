package question07;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
//		이름 4개 입력받기
		for (int i = 0; i < 4; i++) {
			System.out.print("이름을 입력하세요>> ");
			names.add(scanner.next());
		}
		
//		모든 이름 출력
		for (String name : names) {
			System.out.print(name + " ");
		}
		System.out.println();
		
//		가장 긴 이름 찾기
		String longestName = "";
		for (String name : names) {
			if (name.length() > longestName.length()) {
				longestName = name;
			}
		}
		System.out.println("가장 긴 이름은 : "+longestName);
		
		scanner.close();
	}
}
