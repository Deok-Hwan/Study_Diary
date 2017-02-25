package StringTokenizer;

import java.util.StringTokenizer;
/**
 * 
 * 구분자로 여러 문자들을 지정한 것을 눈여겨보자. 앞서 얘기한 바와 같이 
 * StringTokenizer는 단 한 문자의 구분자만 사용할 수 있기 때문에 , "+-/=()", 전체가 하나의 구분자가 아니라
 *  각각의 문자가 모두 구분자라는 것에 주의해야 한다.
 *  만일 구분자가 두 문자 이상 이라면, Scanner 나 String 클래스의 split 메서드를 사용해야 한다.
 * 
 */
public class StrinTokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "100, 20, 300, 400";
		StringTokenizer st = new StringTokenizer(source, ", ");
		
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
		
		String expression = "x=100*(200+300)/2";
		StringTokenizer str = new StringTokenizer(expression, "+-*/=()", true);
		// 마지막 타입을 true로 입력하여 구분자도 토큰으로 간주하도록 하였다.
		
		while(str.hasMoreTokens()){
			System.out.println(str.nextToken());
		}
		
		func1();
	}
	static void func1(){ // 문자열에 포함된 데이터가 두 가지 종료의 구분자로 나뉘어져 있을 때 두 개의 이중 반복문을 사용해서 처리.
		String source = "1, 김천재, 100, 100, 100|2, 박수재, 95, 80, 90|3, 이자바, 80, 90, 90";
		StringTokenizer st = new StringTokenizer(source, "|");
		
		while(st.hasMoreTokens()){
			String token = st.nextToken();
			
			StringTokenizer st2 = new StringTokenizer(token, ", ");
			while(st2.hasMoreTokens()){
				System.out.println(st2.nextToken());
			}
			System.out.println("--------------");
		}
	}
}
