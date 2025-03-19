package question10;

import java.util.Scanner;

class PhoneDirectory {
	private static String[] names;
	private static String[] phoneNumbers;
	private static int size;
	
	public static void init(int nums) {
		names = new String[nums];
		phoneNumbers = new String[nums];
		size =0;
	}
	public static void addEntry(String name, String phoneNumber) {
		names[size] = name;
		phoneNumbers[size] = phoneNumber;
		size++;
	}
	public static String searchNumber(String name) {
		for (int i = 0; i < size; i++) {
			if (names[i].equals(name)) {
				return phoneNumbers[i];
			}
		}
		return null;
	}
}

public class PhoneBook {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("인원수>>");
		int nums = scanner.nextInt();
		scanner.nextLine();
		
		PhoneDirectory.init(nums);
		
		for (int i = 0; i < nums; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력)>>");
			String input = scanner.nextLine();
			String[] parts = input.split(" ");
			PhoneDirectory.addEntry(parts[0], parts[1]);
		}
		System.out.println("저장되었습니다....");
		
		while (true) {
			System.out.print("검색할 이름>> ");
			String searchName = scanner.nextLine();
			
			if (searchName.equals("그만")) {
				break;
			}
			String phoneNumber = PhoneDirectory.searchNumber(searchName);
			if (phoneNumber == null) {
				System.out.println(searchName +"이 없습니다.");
			} else {
				System.out.println(searchName +"의 번호는 "+phoneNumber);

			}
		}
		System.out.println("검색을 종료합니다.");
		scanner.close();
	}
}
