package LangUtilClass;

import java.util.Collections;
import java.util.Comparator;

public class hashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode()); // String 클래스는 문자열의 내용이 같으면 , 
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
	}

}
