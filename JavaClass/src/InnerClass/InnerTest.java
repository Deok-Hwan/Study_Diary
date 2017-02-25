package InnerClass;
/**
 * 
 * @inner class ��� ����
 *  Ŭ������ ��Ī�� ��ĥ �� ���.
 *  �������� ĸ��ȭ (����)�� ���� �����
 *  Ŭ�������� ������ ��ȯ�� ���� �����
 *
 */
public class InnerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aaa = new A();
		aaa.a = 3;
		A.B BBB= aaa.new B(); // ���� inner Ŭ���� - �ν��Ͻ� Ŭ���� ��ü ����.
		A.B ccc = new A().new B();
	} // end of main
}
class A{ // outer class �ܺ� Ŭ����
	int a; // �ν��Ͻ� ���� 
	static int b; // static ����
	
	void print(){ // ���� inner class.
		int c;
	}
	class B{ // inner class ���� Ŭ����
		int inb; // �ν��Ͻ� ���� 
//		static int ins ; // �ν��Ͻ� ���� Ŭ���������� static �ɹ��� ���� �� ����.
		
		void p() {} // �ν��Ͻ� �޼���
	
	}
}//end of class A