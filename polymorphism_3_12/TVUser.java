package polymorphism_3_12;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// 1.스프링 컨테이너 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 스프링 컨테이너로부터 (getBean() 메소드로 tv객체) 필요한 객체를 요청(Lookup)
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. 스프링 컨테이너 종료
		factory.close();
	}
	// spring의 빈컨테이너 이용 : 의존성 주입 DI
	// IoC 제어의 역행 : 개발자가 객체를 관리하는 것이 아니라, 스프링에게 위임
	// DI 객체를 코드 내에서 생성하지 않고 외부컨테이너에서 생성해서 의존성 주입
}
