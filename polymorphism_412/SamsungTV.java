package polymorphism_412;

public class SamsungTV implements TV {
	private SonySpeaker speaker;
		
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}

	public void volumeUp() {
		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	// 의존성 관계 : 결합력이 높다
	public void volumeDown() {
		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
