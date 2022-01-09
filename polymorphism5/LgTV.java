package polymorphism5;

import javax.annotation.Resource;	// 톰캣에서

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/*
 * 어노테이션 기반 설정
 * @Component 클래스 선언부 위 설정
 * 해당 클래스에 기본 생성자 있어야 컨테이너가 객체 생성 가능
 * 
 */
@Component("tv")
public class LgTV implements TV {
	/*
	 * @Autowired 멤버변수 추가 후 의존관계 설정
	 * @Qualifier 의존성 주입 대상이 되는 speaker객체가 두개 이상일때 대상 변수 위 사용
	 * @Resource 객체 이름을 이용해서 의존성 주입. name속성 사용
	 */
	// @Autowired
	// @Qualifier("apple")
	@Resource(name="apple")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	}
	
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
	}

	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
