package InnerClass;

class Parent{
	int a;
	void print(){
		System.out.println("�ƺ�");
	}
}
public class InnerClass7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent c = new Parent(){ // �͸� Ŭ����
			int b; // �߰��� ����
			void read(){ // �߰��� �޼��� , �͸� Ŭ�������� �߰��� �޼���� ��� �� ���� ����.
			}
			void print(){ // �������̵�
				read(); // �� �͸�Ŭ���� ���ο��� �����ϸ� ��� �����ϴ�.
			}
		};
		c = new Parent();
		c.a++; c.print(); 
		love(new Parent() { // �Ű� ������ �͸� Ŭ���� ���
			void sum(){
				System.out.println("3");
			}
			void Print(){
				System.out.println("����");
			}
		});
	}
	
	public static void love(Parent p ) {
		System.out.println("���� �޼���");
		p.print();
	}
}
