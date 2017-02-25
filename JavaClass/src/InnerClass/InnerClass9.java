package InnerClass;
/**
 * 
 *  익명클래스 - 추상클래스
 *	익명클래스 단독으로 사용할 수 없다.
 *	class를 상속 or interface를 구현 해야만 객체를 생성할 수 있다.
 *	익명클래스는 생성자를 사용할 수 없다.
 *	익명클래스 작성시 호출하는 생성자는 상속(구현) 받을 부모의 생성자.
 *	부모가 가지고 있는 생성자를 호출해야 한다.
 */
public class InnerClass9 {
	public static void main(String[] args) {
		Fight f = new Fight() {
			
			@Override
			void fight() {
				// TODO Auto-generated method stub
				System.out.println("싸움");
			}
		};
		
	}
	
}
class ChildFight extends Fight{
	@Override
	void fight() {
		// TODO Auto-generated method stub
		
	}
}

abstract class Fight{
	abstract void fight() ;
	private void print() {
		// TODO Auto-generated method stub

	}
	
	public Fight() {
		System.out.println("추상 클래스 생성자");
	}
}