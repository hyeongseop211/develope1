package com.lgy.Spring_ex2_5;

public class Multiple {
	private boolean multiple;
	private int num;

	public void process() {
		boolean multiple=false;
		if (num %3 == 0) {
			System.out.println();
			multiple=true;
		}
		if (num %5 == 0) {
			System.out.println();
			multiple=true;
		}
		if (num %8 == 0) {
			System.out.println();
			multiple=true;
		}
		if (!multiple) {
			System.out.println();
			multiple=true;
		}
	}
	
	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
