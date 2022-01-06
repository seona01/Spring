package polymorphism_421;

public class SamsungTV implements TV {
	private SonySpeaker speaker;	// ref속성 : <bean>객체(아이디, 이름 참조)
	private int price;	// 멤버변수 추가. value속성 : 기본형데이터
		
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(SonySpeaker speaker, int price) {	// 오버로딩시
		System.out.println("===> SamsungTV(3) 객체 생성");
		this.speaker = speaker;			// 인자 순서 : index 속성 참조
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다. (가격 : " + price + ")");
	}

	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
