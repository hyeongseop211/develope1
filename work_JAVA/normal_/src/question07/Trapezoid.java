package question07;

import java.util.Scanner;

class Main {
	private double down;
	private double up;
	private double height;
	
	public Main(double down, double up, double height) {
		this.down = down;
		this.up = up;
		this.height = height;
	}
	
	public double getArea() {
		return (down + up)*height/2;
	}
}

public class Trapezoid {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(">> ");
		double down = scanner.nextDouble();
		double up = scanner.nextDouble();
		double height = scanner.nextDouble();
		
		Main trapezoid = new Main(down, up ,height);
		
		System.out.println("사다리꼴의 면적은 "+ trapezoid.getArea());
		
		scanner.close();
	}
	
}
