package StrategyPattern;
/**
 * 
 * @author �ڴ�ȯ
 * ��Ʈ��Ƽ�� ������ ���� ������ �ذ��ϴ� ���� �˰���(���)�� Ŭ�������� ĸ��ȭ �Ǿ� �ְ�
 * �̵��� �ʿ��� �� ��ü�� �� �ֵ��� �����ν� ������ ������ �ٸ� �˰������� �ذ��� �� �ִ� ������ �����̴�.
 * 
 */
class Robot{
	private String name;
	private MovingStrategy movingStrategy;
	private AttackStrategy attackStrategy;
	
	public Robot(String name) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	public String getName(){
		return this.name;
	}
	public void move(){
		movingStrategy.move();
	}
	public void attack(){
		attackStrategy.attack();
	}
	public void setMovingStrategy(MovingStrategy movingStrategy) {
		this.movingStrategy = movingStrategy;
	}
	public void setAttackStrategy(AttackStrategy attackStrategy) {
		this.attackStrategy = attackStrategy;
	}	
}
class Atom extends Robot{
	public Atom(String name){
		super(name);
	}
}
class TaekwonV extends Robot{
	public TaekwonV(String name){
		super(name);
	}
}
interface MovingStrategy{
	public void move();
}
class FlyingStrategy implements MovingStrategy{
	public void move(){
		System.out.println("I can Fly.");
	}
}
class WalkingStrategy implements MovingStrategy{
	public void move() {
		System.out.println("I can only walk.");
	}
}
interface AttackStrategy{
	public void attack();
}
class MissileStrategy implements AttackStrategy{
	public void attack(){
		System.out.println("I have Misile and can attack with it ");
	}
}
class PunchStrategy implements AttackStrategy{
	public void attack() {
		System.out.println("I have strong punch and can attack with it");
	}
}

public class Client {
	public static void main(String[] args) {
		Robot taekwonV = new TaekwonV("TeakwonV");
		Robot atom = new Atom("Atom");
		
		taekwonV.setMovingStrategy(new WalkingStrategy());
		taekwonV.setAttackStrategy(new MissileStrategy());
		
		atom.setMovingStrategy(new FlyingStrategy()); // �̵� ������ ���ư��ٴ� �������� ����
		atom.setAttackStrategy(new PunchStrategy()); // ���� ������ ��ġ�� �����Ѵٴ� �������� ����
		
		System.out.println("My name is " + taekwonV.getName());
		taekwonV.move();
		taekwonV.attack();
		System.out.println();
		
		System.out.println("My name is " + atom.getName());
		atom.move();
		atom.attack();
		
	}
}
