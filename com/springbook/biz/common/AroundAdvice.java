package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		System.out.println(method + "() 메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		return obj;
	}
}
/*
 * 어드바이스 : 각 조인포인트에 삽입되어 동작할 횡단 관심에 해당하는 공통기능
 * around 어드바이스 : 비즈니스 메소드 실행 전과 후 모두 동작
 * 비즈니스 메소드 실행 전 -> 사전 처리 로직 수행
 * 비즈니스 메소드 실행 후 -> 사후 처리 로직 수행
 * around 어드바이스에서만 ProceedingJoinPoint를 매개변수로 사용. proceed() 메소드가 필요
 * <aop:around> 엘리먼트 사용
 */