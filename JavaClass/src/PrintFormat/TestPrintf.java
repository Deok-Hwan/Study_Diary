package PrintFormat;

public class TestPrintf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[ȫ�浿]");
		System.out.println("[ �浿]");
		System.out.println(3.141592);
		System.out.printf("%10.3f\n",3.141592); // 10.3f �� 10�� �� 10ĭ �߿� ������ ���� , -10�� ���� �������Ѵ�.
		System.out.println("%3c"); // 10.3f�� 3�� �Ҽ��� ��°�ڸ����� ����Ѵ�. 
		String name = "�浿";
		System.out.printf("[%-5s]\n",name);
		
		double d = 123.141592;
		String s = "apple";
		System.out.println("123456789");
		System.out.printf("%-8.2f\n",d);
		System.out.printf("%7s\n",s);
		
		System.err.println("����");
	}

}
