package InnerClass;
/**
 * 
 *  �͸�Ŭ���� - �߻�Ŭ����
 *	�͸�Ŭ���� �ܵ����� ����� �� ����.
 *	class�� ��� or interface�� ���� �ؾ߸� ��ü�� ������ �� �ִ�.
 *	�͸�Ŭ������ �����ڸ� ����� �� ����.
 *	�͸�Ŭ���� �ۼ��� ȣ���ϴ� �����ڴ� ���(����) ���� �θ��� ������.
 *	�θ� ������ �ִ� �����ڸ� ȣ���ؾ� �Ѵ�.
 */
public class InnerClass9 {
	public static void main(String[] args) {
		Fight f = new Fight() {
			
			@Override
			void fight() {
				// TODO Auto-generated method stub
				System.out.println("�ο�");
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
		System.out.println("�߻� Ŭ���� ������");
	}
}