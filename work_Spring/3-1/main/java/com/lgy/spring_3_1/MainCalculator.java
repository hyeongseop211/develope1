package com.lgy.spring_3_1;

public class MainCalculator {
	public static void main(String[] args) {
		MyCalculator mycalculator = new MyCalculator();
		mycalculator.setCalculator(new Calculator());
		
		mycalculator.setFirstNum(10);
		mycalculator.setSecondNum(2);
		
		mycalculator.add();
		mycalculator.sub();
		mycalculator.mul();
		mycalculator.div();
	}
}
