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
	
	public void pressed() { // 버튼이 눌리면 주어진 Command의 execute 메서드를 호출함
		theCommand.execute();
	}
}
class Lamp{
	public void turnOn(){
		System.out.println("Lamp On");
	}
}

class LampOnCommand implements Command{ // 램프를 켜는 클래스
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

class AlarmOnCommand implements Command { // 알람을 울리는 클래스
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
		
		Button button1 = new Button(lampOnCommand); // 램프를 켜는 커맨드를 설정함
		button1.pressed(); // 버튼이 눌리면 램프 켜는 기능이 실행됨.
		
		Alarm alarm = new Alarm();
		Command alarmOnCommand = new AlarmOnCommand(alarm);
		
		Button button2 = new Button(alarmOnCommand);
		button2.pressed();
		
		button2.setCommand(lampOnCommand);
		button2.pressed();
		
	}
}
