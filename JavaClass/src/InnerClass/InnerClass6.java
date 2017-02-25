package InnerClass;
/**
 * 
 *  외부클래스에서 내부 클래스로 접근
 */
public class InnerClass6 { 
	public static void main(String[] args) {
		K.T A = new K().new T(); //K 객체를 만들고 T 객체를 만듬
		K.ST A1 = new K.ST();
		A1.ppp();
		K k =new K ();
		k.print();
		
	}
	
}
class K {
	int a = 3;
	static int sa = 4;
	
	void print() {
		int a = 5;
		class LT {
			int a = 3000;
			void ppp() {
				System.out.println(a);
			}
		}
		LT lt = new LT();
		lt.ppp();
	}
	static class ST{
		int a = 200;
		void ppp() {
			System.out.println(a);
		}
	}
	class T { // 내부 클래스에서는 외부 클래스의 변수를 공유한다.
		void ppp() {
			System.out.println(K.this.a); // Outer클래스를 접근할때 에는 클래스.this.변수명 으로 접근할 수 있다.
			K.this.print();
		}
	}
}
