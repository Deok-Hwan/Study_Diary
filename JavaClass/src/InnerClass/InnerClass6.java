package InnerClass;
/**
 * 
 *  �ܺ�Ŭ�������� ���� Ŭ������ ����
 */
public class InnerClass6 { 
	public static void main(String[] args) {
		K.T A = new K().new T(); //K ��ü�� ����� T ��ü�� ����
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
	class T { // ���� Ŭ���������� �ܺ� Ŭ������ ������ �����Ѵ�.
		void ppp() {
			System.out.println(K.this.a); // OuterŬ������ �����Ҷ� ���� Ŭ����.this.������ ���� ������ �� �ִ�.
			K.this.print();
		}
	}
}
