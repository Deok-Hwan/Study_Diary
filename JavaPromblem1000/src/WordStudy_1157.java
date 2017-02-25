import java.util.Scanner;
public class WordStudy_1157 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		str = str.toUpperCase();
		int [] count_arr = new int[str.length()];
		String s = new String();

		for(int i=0; i<str.length() ;i++)
		{
			String change = "";
			change = String.valueOf(str.charAt(i));
			if(!(s.contains(change)))
			{
				s = s.concat(change);
			}
		}

		int count = 0;
		for(int j=0; j<s.length() ; j++)
		{
			for(int i=0; i<str.length() ;i++)
			{
				if(s.charAt(j) == str.charAt(i))
				{
					count ++;
				}
			}
			count_arr[j] = count;
			count = 0;
		}
		int max_count = 0;
		int max_index = 0;
		for(int i=0; i<s.length() ; i++)
		{
			if(count_arr[i] > max_count){
				max_count = count_arr[i];
				max_index = i;
			}
		}
		
		
		int m = 0;
		for(int i=0; i<s.length() ;i++)
		{
			if(count_arr[i] == count_arr[max_index])
			{
			m++;
			}
		}
		if(m > 1)
		{
			System.out.println("?");
		}
		else
			System.out.println(s.charAt(max_index));
	}

}