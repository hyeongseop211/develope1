package question08;

import java.util.Scanner;

class Calculator {
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
//덧셈 클래스
class Add extends Calculator {
 @Override
 public int calculate() {
     return a + b;
 }
}

//뺄셈 클래스
class Sub extends Calculator {
 @Override
 public int calculate() {
     return a - b;
 }
}

//곱셈 클래스
class Mul extends Calculator {
 @Override
 public int calculate() {
     return a * b;
 }
}

//나눗셈 클래스
class Div extends Calculator {
 @Override
 public int calculate() {
     if(b == 0) {
         System.out.println("0으로 나눌 수 없습니다.");
         return 0;
     }
     return a / b;
 }
}
public class Calc {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Add add= new Add();
		Sub sub= new Sub();
		Mul mul= new Mul();
		Div div= new Div();
		
		System.out.print("두 정수와 연산자를 입력하시오>> ");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		String operator = scanner.next();
		
		switch (operator) {
		case "+":
			add.setValue(num1, num2);
			System.out.println(add.calculate());
			break;
		case "-":
			sub.setValue(num1, num2);
			System.out.println(sub.calculate());
			break;
		case "*":
			mul.setValue(num1, num2);
			System.out.println(mul.calculate());
			break;
		case "/":
			div.setValue(num1, num2);
			System.out.println(div.calculate());
			break;

		default:
			System.out.println("잘못된 연산자");;
		}
		scanner.close();
	}
}

















