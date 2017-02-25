package StrategyPattern;
/**
 * 
 * @author 박덕환
 * 스트래티지 패턴은 같은 문제를 해결하는 여러 알고리즘(방식)이 클래스별로 캡슐화 되어 있고
 * 이들이 필요할 때 교체할 수 있도록 함으로써 동일한 문제를 다른 알고리즘으로 해결할 수 있는 디자인 패턴이다.
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
		
		atom.setMovingStrategy(new FlyingStrategy()); // 이동 전략을 날아간다는 전략으로 설정
		atom.setAttackStrategy(new PunchStrategy()); // 공격 전략을 펀치를 구사한다는 전략으로 설정
		
		System.out.println("My name is " + taekwonV.getName());
		taekwonV.move();
		taekwonV.attack();
		System.out.println();
		
		System.out.println("My name is " + atom.getName());
		atom.move();
		atom.attack();
		
	}
}
