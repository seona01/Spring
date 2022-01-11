package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	// exceptionLog() 메소드는 예외가 발생한 메소드 정보 알아내기 위해 JoinPoint 객체를 매개변수로 받음
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {				// exceptObj : 바인드변수. 모든 예외 객체를 바인드할 수 있도록 예외 클래스 최상위 타입인 Exception 선언
		String method = jp.getSignature().getName();
//		System.out.println("[예외 처리] " + method + "() 메소드 수행 중 발생된 예외 메시지 : " + exceptObj.getMessage());

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
 * <aop:after-throwing> 엘리먼트 사용
 */