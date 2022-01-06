package polymorphism_42;

public class SamsungTV implements TV {
	private SonySpeaker speaker;
		
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	
	// 생성자 인젝션 이용
	// 매개변수를 가지는 다른 생성자 호출
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
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
