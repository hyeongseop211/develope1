package com.lgy.spring_ex9;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {

//	공통기능이 적용된 범위
	@Pointcut("within(com.lgy.spring_ex9.*)")
	private void pointCutMethod() {}
	
//	메소드 실행 전/후, 예외처리 포함해서 공통기능 실행
	@Around("pointCutMethod()")// 적용되는 메소드 명
	public Object loggerAop(ProceedingJoinPoint joinPoint) {
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println("@@@### start===>"+signatureStr);
		long st = System.currentTimeMillis();
		Object obj=null;
		
		try {
			joinPoint.proceed();//예외처리 추가
		} catch (Throwable e) {
			e.printStackTrace();
		}finally {
			long et =System.currentTimeMillis();
			System.out.println("@@@### end===>"+signatureStr);
			System.out.println(signatureStr+"의 경과시간 : "+(et-st));
		}
		
		return obj;//핵심기능 반환
	}

}
