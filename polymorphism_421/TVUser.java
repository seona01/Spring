package polymorphism_421;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
				
		factory.close();
	}
	// 생성자 인젝션 : 다중 변수 매핑
	// IoC 제어의 역행 : 개발자가 객체를 관리하는 것이 아니라, 스프링에게 위임
	// DI 객체를 코드 내에서 생성하지 않고 외부컨테이너에서 생성해서 의존성 주입
}
