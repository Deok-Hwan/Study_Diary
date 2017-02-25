package SingletonPattern;
/**
 * 싱글턴 패턴은 인스턴스가 오직 하나만 생성되는 것을 보장하고 어디에서든 이 인스턴스에
 * 접근할 수 있도록 하는 디자인 패턴이다. 원래 싱글턴이라는 단어는 '단 하나의 원소만을 가진 집합'
 * 이라는 수학 이론에서 유래 되었다.
 */

class Printer{// 정적 변수에 인스턴스를 만들어 바로 초기화 하는 방법
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
 * 인스턴스를 만드는 메서드에 동기화는 방법
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
