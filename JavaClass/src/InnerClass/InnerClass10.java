package InnerClass;
/**
 * 
 * ���� Ŭ���� - interface
 *
 */

public class InnerClass10 {
	public static void main(String[] args) {
		Fightable f2 = new Fightable(){
			@Override
			public void fight() {
				// TODO Auto-generated method stub
				
			}
		};
		
		friend(f2);
		
	}//end of main
	public static void friend(Fightable f3)
	{
		
	}
	
}//end of class

interface Fightable{ // interfae�� -able�� �Ҽ��ְ� ����
	public static final int x = 3;
	public abstract void fight();
	
}
