package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// BeforeAdvice 클래스가 컴포넌트 스캔되어 애스팩트 객체로 인식되도록
@Service
@Aspect
public class BeforeAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
	}
	
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp){
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리] " + method +
				"() 메소드 ARGS 정보 : " + args[0].toString());
	}
}
/*
 * 어드바이스 : 각 조인포인트에 삽입되어 동작할 횡단 관심에 해당하는 공통기능
 * before 어드바이스 : 포인트컷으로 지정된 메소드 호출 시, 메소드가 실행되기 전에 처리될 내용
 * 					비즈니스 메소드 실행 전 동작할 로직 구현
 * 
 * JoinPoint 인터페이스: 예외 발생한 비즈니스 메소드 이름, 메소드가 속한 클래스, 패키지 정보를 제공하여
 * 						정확한 예외 처리 로직 구현
 */
