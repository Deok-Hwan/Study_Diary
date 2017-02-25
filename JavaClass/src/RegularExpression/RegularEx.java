package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @정규식 표현 : 
 * 1. 정규식을 매개변수로 Pattern 클래스의 static 메서드인 Pattern compile(String regex)을 호출하여
 * Pattern 인스턴스를 얻는다.
 * Pattern p = Pattern.compile("c[a-z]*");
 * 
 *  2. 정규식으로 비교할 대상을 매개변수로 Pattern 클래스의 matcher matcher(CharSequence input)를 호출해서
 *  Matcher 인스턴스를 얻는다.
 *  Matcher m = p.matcher(data[i]);	
 *
 * 3. Matcher인스턴스에 boolean matches() 를 호출해서 정규식에 부합하는지 확인한다.
 *  if(m.matches())
 */
public class RegularEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] data = {"bat", "baby", "bonus", "cA", "Ca", "co","c.",
				"c0","car","combat","count","date","disc"};
		
		Pattern p = Pattern.compile("c[a-z]*"); // c로 시작하는 소문자.
		
		for(int i=0 ; i<data.length ; i++)
		{
			Matcher m = p.matcher(data[i]);
			if(m.matches())
			{
				//System.out.println(data[i]+ ", ");
			}
		}	
		
		func1();
	}
	
	static void func1(){
		String [] data = {"bat", "baby", "bonus", "cA", "Ca", "co","c.",
				"c0","car","combat","count","date","disc"};
		
		String [] pattern = {".*","c[a-z]*","c[a-z]","c[a-zA-Z]",
				"c[a-zA-Z0-9]","c.","c.*","c\\.","c\\w",
				"c\\d","c.t","[b|c].*",".*a",".*a","a.+",
				"[b|c].{2}"
		
		};
		
		for(int x=0 ; x<pattern.length ; x++)
		{
			Pattern p = Pattern.compile(pattern[x]);
			System.out.print("Pattern : " + pattern[x] + " 결과  : ");
			
			for(int i=0 ; i<data.length ;i++)
			{
				Matcher m = p.matcher(data[i]);
				if(m.matches())
				{
					System.out.print(data[i]+ ", ");
				}
			}
			System.out.println();
		}
	}
}
