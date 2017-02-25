package StatePattern;
/**
 * 
 * 스테이트 패턴은 상태에 따라 동일한 작업이 다른 방식으로 실행될 떄 해당 상태가 
 * 작업을 수행하도록 위임하는 디자인 패턴이다.
 *
 */
public interface State {
	public void on_button_pushed(Light light);
	public void off_button_pushed(Light light);
}


class ON implements State{
	private static ON on = new ON();
	private ON() {}
	
	public static ON getInstance() {
		return on;
	}
	
	public void on_button_pushed(Light light){
		System.out.println("반응 없음");
	}
	
	public void off_button_pushed(Light light){
		System.out.println("Light Off!");
		light.setState(OFF.getInstance());
		
	}
}
class OFF implements State{
	private static OFF off = new OFF(); // OFF 클래스의 인스턴스로 초기화됨
	private OFF() {}
	
	public static OFF getInstance() { // 초기화된 OFF 클래스의 인스턴스를 반환함
		return off;
	}
	public void on_button_pushed(Light light) {
		System.out.println("Light On!");
		light.setState(ON.getInstance());
	}
	
	public void off_button_pushed(Light light) {
		System.out.println("반응 없음");
	}
	
}

class Light{
	private State state;
	
	public Light() {
		state = OFF.getInstance();
	}
	public void setState(State state) {
		this.state = state;
	}
	public void on_button_pushed() {
		state.on_button_pushed(this);
	}
	public void off_button_pushed() {
		state.off_button_pushed(this);
	}
}
