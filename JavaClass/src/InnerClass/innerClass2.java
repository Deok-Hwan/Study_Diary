package InnerClass;

public class innerClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class D {
	int age;
	static int tall;
	
	static class E { // ���� Ŭ���� - static Ŭ����
		int cnt  = 6;
		static int water = 10;
		public E(){
			
		}
		void print() {}
	}
	
	public D() {
		System.out.println("D Ŭ���� ������");
	}
	void print() {
		
	}
}// end of class D