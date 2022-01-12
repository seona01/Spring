package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut() {
	}
	
	@AfterReturning(pointcut="getPointcut()", returning="returnObj")			// @AfterReturning : 포인트컷 참조. returning 속성 : 바인드 변수를 지정해야
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if (user.getRole().equals("Admin")) {
				System.out.println(user.getName() + " 로그인(Admin)");
			}
		}
		System.out.println("[사후 처리] " + method + "() 메소드 리턴값 : " + returnObj.toString());
	}
}
/*
 * 어드바이스 : 각 조인포인트에 삽입되어 동작할 횡단 관심에 해당하는 공통기능
 * after returning 어드바이스 : 포인트컷으로 지정된 메소드 정상적으로 실행 후,
 * 메소드 수행 결과로 생성된 데이터 리턴 시점에 동작
 * 비즈니스 메소드 수행 결과로 얻은 데이터 -> 사후 처리 로직을 추가할때 사용
 */