abstract class Unit{
	Point p;
	final int MAX_HP; // 상수 초기화 시점, 1. 선언시, 2. 생성자 3. 초기화 블록
	int hp;

	abstract void move(Point p);
	abstract void stop();
	public Unit(int MAX_HP) {
		// TODO Auto-generated constructor stub
		this.MAX_HP = MAX_HP;
	}

}
abstract class Human extends Unit{
	public Human(int Max_HP) {
		// TODO Auto-generated constructor stub
		super(Max_HP);
	}
}
class Scv extends Human
{
	public Scv() {
		super(40);
		this.hp = 40;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	void move(Point p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	void stop() {
		// TODO Auto-generated method stub
		
	}
	void repair(Machine obj)
	{
		obj.hp++;
	}
}

abstract class Machine extends Unit
{
	public Machine() {
		super(50);
		// TODO Auto-generated constructor stub
	}
}
class Tank extends Machine
{
	@Override
	void move(Point p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	void stop() {
		// TODO Auto-generated method stub
		
	}
	void changeMode()
	{
		
	}
}
class Dropship extends Tank
{
	@Override
	void move(Point p) {
		// TODO Auto-generated method stub
		super.move(p);
	}
	@Override
	void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}
	void load()
	{
		
	}
	void unload()
	{
		
	}
}

class Point{
	int x,y;
}

public class TestUnit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
