abstract class AbsBoy{ //추상클래스 : 추상메서드를 가질 수 있는 클래스 , 추상메서드가 하나라도 있으면 추상클래스이다.
	int age = 10; // 일반변수
	int tall;
	abstract public void setTall(); // 추상메서드 : 선언부만 작성한 메서드
	public String toString(){ // 일반 메서드
		return "나이: "+age;
	}	
}
abstract class Boy{
	int age = 10;
	public String toString() {
		return "나이 : "+age;
	}
}


public class abstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
class CationTv
{
	int vol;
	int channerl;
	boolean power;
	boolean caption;

}
class SmartTv
{
	
}
