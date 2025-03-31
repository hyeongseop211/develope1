package com.lgy.spring_9_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Mainclass {
	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Champion champion = ctx.getBean("champion", Champion.class);
		
//		공통기능
//		Champion.getChampionInfo()is start.
		
//		핵심기능
//		이름 :룰루
//		티어 :1
//		이름길이 :2
//		승률 :68
		
//		공통기능
//		Champion.getChampionInfo()is finished.
//		Champion.getChampionInfo()의 경과시간 : 0
		champion.getChampionInfo();
		
		Pokemon pokemon = ctx.getBean("pokemon", Pokemon.class);
		
//		공통기능
//		Pokemon.getPokemonInfo()is start.
		
//		핵심기능
//		이름 :피카츄
//		티어 :1
//		기술 :백만볼트
		
//		공통기능
//		Pokemon.getPokemonInfo()is finished.
//		Pokemon.getPokemonInfo()의 경과시간 : 0
		
		pokemon.getPokemonInfo();
		
		ctx.close();
	
	}
}
