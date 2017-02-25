package StringTokenizer;

import java.util.StringTokenizer;
/**
 * 
 * �����ڷ� ���� ���ڵ��� ������ ���� �����ܺ���. �ռ� ����� �ٿ� ���� 
 * StringTokenizer�� �� �� ������ �����ڸ� ����� �� �ֱ� ������ , "+-/=()", ��ü�� �ϳ��� �����ڰ� �ƴ϶�
 *  ������ ���ڰ� ��� �����ڶ�� �Ϳ� �����ؾ� �Ѵ�.
 *  ���� �����ڰ� �� ���� �̻� �̶��, Scanner �� String Ŭ������ split �޼��带 ����ؾ� �Ѵ�.
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
		// ������ Ÿ���� true�� �Է��Ͽ� �����ڵ� ��ū���� �����ϵ��� �Ͽ���.
		
		while(str.hasMoreTokens()){
			System.out.println(str.nextToken());
		}
		
		func1();
	}
	static void func1(){ // ���ڿ��� ���Ե� �����Ͱ� �� ���� ������ �����ڷ� �������� ���� �� �� ���� ���� �ݺ����� ����ؼ� ó��.
		String source = "1, ��õ��, 100, 100, 100|2, �ڼ���, 95, 80, 90|3, ���ڹ�, 80, 90, 90";
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
