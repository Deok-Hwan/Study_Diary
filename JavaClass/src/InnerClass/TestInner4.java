package InnerClass;


/**
 * 
 * 내부 클래스 활용
 *
 */

public class TestInner4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Out.Ins outIns = new Out.Ins();
		Out.InA outIna = new Out().new InA();
		Out out = new Out();
		out.print();
		
	}	

}
class Out {
	int a = 3;
	static int sa = 4;
	class InA{
		int c;
		public InA(){
			
		}
	}
	
	static class Ins{
		int b;
		static int sb;
		public Ins(){
			System.out.println("Ins 의 생성자");
		}
	}
	public Out(){
		System.out.println("Out 클래스 생성자");
	}
	void print(){
		int i = 4;
		class Local{
			int ll;
			public Local(){
				System.out.println("Local의 생성자");
			}
			
		}
	}
}