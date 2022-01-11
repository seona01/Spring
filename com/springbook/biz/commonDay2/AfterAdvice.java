package com.springbook.biz.common;

public class AfterAdvice {
	public void finallyLog() {
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 무조건 동작");
	}
}
/*
 * 어드바이스 : 각 조인포인트에 삽입되어 동작할 횡단 관심에 해당하는 공통기능
 * after returning 어드바이스 : 예외 발생 여부에 상관없이 무조건 수행되는 어드바이스
 * (try-catch-finally구문에서 finally블록과 같다)
 * <aop:after> 엘리먼트 사용 : finallyLog() 메소드 먼저 실행 후, exceptionalLog() 메소드 실행
 */