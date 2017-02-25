package SingletonPattern;
/**
 * �̱��� ������ �ν��Ͻ��� ���� �ϳ��� �����Ǵ� ���� �����ϰ� ��𿡼��� �� �ν��Ͻ���
 * ������ �� �ֵ��� �ϴ� ������ �����̴�. ���� �̱����̶�� �ܾ�� '�� �ϳ��� ���Ҹ��� ���� ����'
 * �̶�� ���� �̷п��� ���� �Ǿ���.
 */

class Printer{// ���� ������ �ν��Ͻ��� ����� �ٷ� �ʱ�ȭ �ϴ� ���
	private static Printer printer = new Printer();
	private int counter = 0;
	private Printer(){}

	public static Printer getPrinter() {
		return printer;
	}

	public void print(String str){
		counter++;
		System.out.println(str);
	}
}
/**
 * 
 * �ν��Ͻ��� ����� �޼��忡 ����ȭ�� ���
 *
 */
class PrinterAnotehr{
	private static PrinterAnotehr printer = null;
	private int counter = 0;
	private PrinterAnotehr() {}
	public synchronized static PrinterAnotehr getPrinter() {
		if(printer == null){
			printer = new PrinterAnotehr();
		}
		return printer;
	}

	public void print(String str){
		counter++;
		System.out.println(str+counter);
	}
}

public class SingletonPattern {

}
