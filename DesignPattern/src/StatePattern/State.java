package StatePattern;
/**
 * 
 * ������Ʈ ������ ���¿� ���� ������ �۾��� �ٸ� ������� ����� �� �ش� ���°� 
 * �۾��� �����ϵ��� �����ϴ� ������ �����̴�.
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
		System.out.println("���� ����");
	}
	
	public void off_button_pushed(Light light){
		System.out.println("Light Off!");
		light.setState(OFF.getInstance());
		
	}
}
class OFF implements State{
	private static OFF off = new OFF(); // OFF Ŭ������ �ν��Ͻ��� �ʱ�ȭ��
	private OFF() {}
	
	public static OFF getInstance() { // �ʱ�ȭ�� OFF Ŭ������ �ν��Ͻ��� ��ȯ��
		return off;
	}
	public void on_button_pushed(Light light) {
		System.out.println("Light On!");
		light.setState(ON.getInstance());
	}
	
	public void off_button_pushed(Light light) {
		System.out.println("���� ����");
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
