package InnerClass;

public class innerClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class D {
	int age;
	static int tall;
	
	static class E { // 내부 클래스 - static 클래스
		int cnt  = 6;
		static int water = 10;
		public E(){
			
		}
		void print() {}
	}
	
	public D() {
		System.out.println("D 클래스 생성자");
	}
	void print() {
		
	}
}// end of class D