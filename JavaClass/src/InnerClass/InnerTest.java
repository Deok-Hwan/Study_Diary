package InnerClass;
/**
 * 
 * @inner class 사용 이유
 *  클래스의 명칭이 겹칠 때 사용.
 *  데이터의 캡슐화 (보안)을 위해 사용함
 *  클래스간의 데이터 교환을 위해 사용함
 *
 */
public class InnerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aaa = new A();
		aaa.a = 3;
		A.B BBB= aaa.new B(); // 내부 inner 클래스 - 인스턴스 클래스 객체 생성.
		A.B ccc = new A().new B();
	} // end of main
}
class A{ // outer class 외부 클래스
	int a; // 인스턴스 변수 
	static int b; // static 변수
	
	void print(){ // 내부 inner class.
		int c;
	}
	class B{ // inner class 내부 클레스
		int inb; // 인스턴스 변수 
//		static int ins ; // 인스턴스 내부 클레스에서는 static 맴버를 가질 수 없다.
		
		void p() {} // 인스턴스 메서드
	
	}
}//end of class A