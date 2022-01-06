package polymorphism_324;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		/*
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		*/
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		
		factory.close();
	}
	// spring의 빈컨테이너 이용 : 의존성 주입 DI
	// IoC 제어의 역행 : 개발자가 객체를 관리하는 것이 아니라, 스프링에게 위임
	// DI 객체를 코드 내에서 생성하지 않고 외부컨테이너에서 생성해서 의존성 주입
	
	// tv객체 하나만 생성 가능
	// tv1, tv2, tv3 객체들은 메모리 낭비
}
