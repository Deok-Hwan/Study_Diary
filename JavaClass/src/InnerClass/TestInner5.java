package InnerClass;
/**
 * 
 * static 맴버의 사용 제한
 
 */
class Out1{ // static 맴버에서 non-static 맴버를 접근할 수 없다.
	int a; // 인스턴스 맴버 변수
	static int sa ; // static 맴버 변수
	
	void p () { // 인스턴스 맴버 메서드
		
	}
	static void sp() {} // statc 맴버 메서드
}
public class TestInner5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
