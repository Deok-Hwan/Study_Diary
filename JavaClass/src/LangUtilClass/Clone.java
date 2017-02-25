package LangUtilClass;
/**
 * 
 * clone()
 *	�ڽ��� �����Ͽ� ���ο� �ν��Ͻ��� �����ϴ� ���� �Ѵ�. 
 *	Object Ŭ������ ���ǵ� clone()�� �ܼ��� �ν��Ͻ��� ����  ������ �����ϱ� ������ ���� ���� Ÿ���� �ν��Ͻ� ������ ���ǵǾ�
 *	�ִ� Ŭ������ ������ �ν��Ͻ� ������ �̷������ �ʴ´�.
 *  �迭�� ���, ������ �ν��Ͻ��� ���� �迭�� �ּҸ� ���� ������ ������ �ν��Ͻ��� �۾��� ������ �ν��Ͻ��� ������ ��ģ��.
 *  
 *  clone()���� ������ ������ Ŭ�������� Ȯ���Ϸ��� Java APi ���� cloneable�� �����Ͽ����� Ȯ���ϸ� �ȴ�.
 */ 

class Point implements Cloneable{
	int x;
	int y;
	
	public Point(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "x= "+x +", y= "+y;
	}
	
	public Object clone(){ // ���ο� object�� �����ؼ� ���� ������ �� ����
		Object obj = null;
		try{
			obj = super.clone();
			
		}catch(CloneNotSupportedException e)
		{}
	
		return obj;
	}
}

public class Clone {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = { 1, 2, 3, 4, 5};
		//int [] arrClone = arr.clone();
		
	}

}
