interface Command{
	public abstract void execute();
}

class Button {
	private Command theCommand;

	public Button(Command theCommand) {
	
	}
	public void setCommand(Command newCommand){
		this.theCommand = newCommand;
	}
	
	public void pressed() { // ��ư�� ������ �־��� Command�� execute �޼��带 ȣ����
		theCommand.execute();
	}
}
class Lamp{
	public void turnOn(){
		System.out.println("Lamp On");
	}
}

class LampOnCommand implements Command{ // ������ �Ѵ� Ŭ����
	private Lamp theLamp;
	
	public LampOnCommand(Lamp theLamp){
		this.theLamp = theLamp;
	}
	public void execute(){
		theLamp.turnOn();
	}
}

class Alarm{
	public void start() {
		System.out.println("Alarming....");
	}
}

class AlarmOnCommand implements Command { // �˶��� �︮�� Ŭ����
	private Alarm theAlarm;
	
	public AlarmOnCommand(Alarm theAlarm){
		this.theAlarm = theAlarm;
	}
	
	public void execute(){
		theAlarm.start();
	}
}


public class CommandPattern {
	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		Command lampOnCommand = new LampOnCommand(lamp);
		
		Button button1 = new Button(lampOnCommand); // ������ �Ѵ� Ŀ�ǵ带 ������
		button1.pressed(); // ��ư�� ������ ���� �Ѵ� ����� �����.
		
		Alarm alarm = new Alarm();
		Command alarmOnCommand = new AlarmOnCommand(alarm);
		
		Button button2 = new Button(alarmOnCommand);
		button2.pressed();
		
		button2.setCommand(lampOnCommand);
		button2.pressed();
		
	}
}
