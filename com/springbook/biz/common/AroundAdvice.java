package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// BeforeAdvice, AfterAdvice처럼 aroundLog()에 바인드 변수가 없으므로 포인트컷 메소드만 참조
@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
	}
	
	@Around("allPointcut()")
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
 */