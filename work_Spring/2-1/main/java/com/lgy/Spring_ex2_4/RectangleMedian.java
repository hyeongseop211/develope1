package com.lgy.Spring_ex2_4;

public class RectangleMedian {
	public static void main(String[] args) {
		Rectangle rec = new Rectangle();
		rec.setX(150);
		rec.setY(150);
		rec.process();
		
		Median med = new Median();
		med.setNum1(20);
		med.setNum2(100);
		med.setNum3(33);
		med.process();
		
	}
}
