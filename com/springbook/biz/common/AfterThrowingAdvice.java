package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
	}
	
	@AfterThrowing(pointcut="allPointcut()", throwing="exceptObj")					// @AfterThrowing : 포인트컷 참조. throwing 속성 : 바인드 변수를 지정해야 해
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		// System.out.println("[예외 처리] " + method + "() 메소드 수행 중 발생된 예외 메시지 : "
		// + exceptObj.getMessage());

		System.out.println(method + "() 메소드 수행 중 예외 발생!");
		if (exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력되었습니다.");
		} else if (exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		} else if (exceptObj instanceof Exception) {
			System.out.println("문제가 발생했습니다.");
		}
	}
}

/*
 * 어드바이스 : 각 조인포인트에 삽입되어 동작할 횡단 관심에 해당하는 공통기능
 * after throwing 어드바이스 : 포인트컷으로 지정된 메소드 실행되다가,
 * 예외 발생하는 시점에 동작
 */