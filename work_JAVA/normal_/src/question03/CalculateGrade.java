package question03;

import java.util.Scanner;

public class CalculateGrade {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("부정행위 여부 (false, true)");
		boolean cheating = scanner.nextBoolean();
		System.out.print("출석률(0~100)사이의 정수값");
		int attendrate = scanner.nextInt();
		System.out.print("총점(0~100)사이의 정수값");
		int totalscore = scanner.nextInt();
		char grade;
		
		if (cheating || attendrate <80) {
			grade = 'F';
		}else if (totalscore >= 90) {
			grade = 'A';
		}else if (totalscore >= 80) {
			grade = 'B';
		}else if (totalscore >= 70) {
			grade = 'C';
		}else if (totalscore >= 60) {
			grade = 'D';
		}
		else {
			grade = 'F';
		}
		System.out.println("학점: "+grade);
		
		scanner.close();
	}




}
