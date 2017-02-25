package LangUtilClass;
/**
 * 
 * clone()
 *	자신을 복제하여 새로운 인스턴스를 생성하는 일을 한다. 
 *	Object 클래스에 정의된 clone()은 단순히 인스턴스의 변수  값만을 복사하기 때문에 참조 변수 타입의 인스턴스 변수가 정의되어
 *	있는 클래스는 완전한 인스턴스 복제가 이루어지지 않는다.
 *  배열의 경우, 복제된 인스턴스도 같은 배열의 주소를 갖기 때문에 복제된 인스턴스의 작업이 원레의 인스턴스에 영향을 미친다.
 *  
 *  clone()으로 복제가 가능한 클레스인지 확인하려면 Java APi 에서 cloneable을 구현하였는지 확인하면 된다.
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
	
	public Object clone(){ // 새로운 object를 생성해서 값을 복사한 후 리턴
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
