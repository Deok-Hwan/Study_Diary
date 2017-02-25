import java.util.Arrays;
import java.util.Scanner;

public class DialTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		char [] ch = {'A','B','C','D','E','F','G'
				,'H','I','J','K','L','M','N','O',
				'P','Q','R','S','T','U','V','W','X',
				'Y','Z'};
		int [] time = {3,3,3,4,4,4,5,5,5
				,6,6,6,7,7,7,8,8,8,8,9,9,
				9,10,10,10,10};
		
		int Time = 0;
		
		for(int i=0 ; i<str.length() ;i++)
		{
			for(int j=0 ; j<26; j++)
			{
				if(str.charAt(i) == ch[j])
				{
					Time += time[j];
					break;
				}
			}
		}
		
		System.out.println(Time);
	}
}
