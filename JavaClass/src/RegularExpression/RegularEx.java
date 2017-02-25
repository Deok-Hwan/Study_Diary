package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @���Խ� ǥ�� : 
 * 1. ���Խ��� �Ű������� Pattern Ŭ������ static �޼����� Pattern compile(String regex)�� ȣ���Ͽ�
 * Pattern �ν��Ͻ��� ��´�.
 * Pattern p = Pattern.compile("c[a-z]*");
 * 
 *  2. ���Խ����� ���� ����� �Ű������� Pattern Ŭ������ matcher matcher(CharSequence input)�� ȣ���ؼ�
 *  Matcher �ν��Ͻ��� ��´�.
 *  Matcher m = p.matcher(data[i]);	
 *
 * 3. Matcher�ν��Ͻ��� boolean matches() �� ȣ���ؼ� ���ԽĿ� �����ϴ��� Ȯ���Ѵ�.
 *  if(m.matches())
 */
public class RegularEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] data = {"bat", "baby", "bonus", "cA", "Ca", "co","c.",
				"c0","car","combat","count","date","disc"};
		
		Pattern p = Pattern.compile("c[a-z]*"); // c�� �����ϴ� �ҹ���.
		
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
			System.out.print("Pattern : " + pattern[x] + " ���  : ");
			
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
