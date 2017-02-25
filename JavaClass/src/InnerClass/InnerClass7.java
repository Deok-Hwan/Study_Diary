package InnerClass;

class Parent{
	int a;
	void print(){
		System.out.println("아빠");
	}
}
public class InnerClass7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent c = new Parent(){ // 익명 클래스
			int b; // 추가한 변수
			void read(){ // 추가한 메서드 , 익명 클래스에서 추가한 메서드는 사용 할 수가 없다.
			}
			void print(){ // 오버라이딩
				read(); // 단 익명클래스 내부에서 선언하면 사용 가능하다.
			}
		};
		c = new Parent();
		c.a++; c.print(); 
		love(new Parent() { // 매개 변수의 익명 클래스 사용
			void sum(){
				System.out.println("3");
			}
			void Print(){
				System.out.println("엄마");
			}
		});
	}
	
	public static void love(Parent p ) {
		System.out.println("러브 메서드");
		p.print();
	}
}
