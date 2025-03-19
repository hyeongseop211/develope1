package question09;

import java.util.Scanner;


abstract class Calc{
	protected int a;
	protected int b;
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return 0;
	}
}
class Add extends Calc {
	 @Override
	 public int calculate() {
	     return a + b;
	 }
	}
class Sub extends Calc {
	 public int calculate() {
	     return a - b;
	 }
	}

	//곱셈 클래스
	class Mul extends Calc {
	 public int calculate() {
	     return a * b;
	 }
	}

	//나눗셈 클래스
	class Div extends Calc {
	 public int calculate() {
	     if(b == 0) {
	         System.out.println("0으로 나눌 수 없습니다.");
	         return 0;
	     }
	     return a / b;
	 }
	}
public class Calculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오>> ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operator = scanner.next();
		
		Calc calc;
		switch (operator) {
		case "+":
			calc = new Add();
			break;
		case "-":
			calc = new Sub();
			break;
		case "*":
			calc = new Mul();
			break;
		case "/":
			calc = new Div();
			break;
		default:
			System.out.println("잘못된 연산자입니다.");
			scanner.close();
			return;
		}
		
		calc.setValue(a, b);
		if (calc instanceof Div && b== 0) {
			System.out.println("계산할 수 없습니다.");
		} else {
			System.out.println(calc.calculate());
		}
		scanner.close();
	}
}
