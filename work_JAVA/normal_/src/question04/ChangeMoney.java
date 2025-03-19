package question04;

import java.util.Scanner;

public class ChangeMoney {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		
		System.out.print("금액을 입력하시오>>");
        int money = scanner.nextInt();
        
        int 오만원 = money / 50000;
        money %= 50000;
        
        int 만원 = money / 10000;
        money %= 10000;
        
        int 천원 = money / 1000;
        money %= 1000;
        
        int 백원 = money / 100;
        money %= 100;
        
        int 오십원 = money / 50;
        money %= 50;
        
        int 십원 = money / 10;
        money %= 10;
        
        int 일원 = money;
        
        if(오만원 > 0) System.out.println("오만원권 " + 오만원 + "매");
        if(만원 > 0) System.out.println("만원권 " + 만원 + "매");
        if(천원 > 0) System.out.println("천원권 " + 천원 + "매");
        if(백원 > 0) System.out.println("백원 " + 백원 + "개");
        if(오십원 > 0) System.out.println("오십원 " + 오십원 + "개");
        if(십원 > 0) System.out.println("십원 " + 십원 + "개");
        if(일원 > 0) System.out.println("일원 " + 일원 + "개");
        
        scanner.close();
		
//		int[] units = {50000,10000,1000,500,100,50,10,1};
//		String[] names = {"오만원권","만원권","천원권","오백원","백원","오십원","십원","일원"};
//		
//		System.out.print("금액을 입력하시오>>");
//		int money = scanner.nextInt();
//		
//		for (int i = 0; i < units.length; i++) {
//			int count = money/units[i];
//			if (count>0) {
//				System.out.println(names[i]+" "+count+(i<=2? "매":"개"));
//				money %= units[i];
//			}
//		}
//		scanner.close();
	}
}
