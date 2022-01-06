package polymorphism_324;

public class BeanFactory {
	public Object getBean(String beanName) {
		if (beanName.equals("samsung")) {
			return new SamsungTV();
		} else if (beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
	
	// 디자인 패턴 이용 : BeanFactory 클래스(객체 관리) 추가
}

