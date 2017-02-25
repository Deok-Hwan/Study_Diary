import java.util.Scanner;
public class GroupWordCheck_1316 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int numOfGroupWord = 0;
		
		sc.nextLine();
		for(int i=0; i<num ; i++)
		{
			
			String s = sc.nextLine();
			s = s.concat("*");
			char [] ch = new char[s.length()];
			for(int j=0 ; j<ch.length ;j++) ch[j] ='*'; 
			
			boolean check_GroupWord = false;
			
			for(int j=0, k=0; j<s.length() -1 ;j++)
			{
				
				if(s.charAt(j) == s.charAt(j+1))
				{
					
				}
				else
				{
					for(int p=0; p<ch.length ;p++)
					{
						if(ch[p] == s.charAt(j)){
							check_GroupWord = true;
						}
						if(ch[p] == '*')
							break;
					}
					ch[k] = s.charAt(j);	
					k++;
				}
			}
			
			
			if(check_GroupWord == false){numOfGroupWord ++;}
		}
		
		System.out.print(numOfGroupWord);
	}

}