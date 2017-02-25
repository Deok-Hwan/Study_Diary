import java.util.Scanner;
import java.util.Stack;

public class bracketCheck1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numOfCase = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<numOfCase ; i++)
		{
			Stack<Character> stack = new Stack<Character>();
			int numOfClose = 0;
			String statement = sc.nextLine();
			
			for(int j=0 ; j<statement.length() ; j++)
			{
				stack.push(statement.charAt(j));
			}

			for(int j=0 ; j<statement.length() ;j++)
			{
				char ch = stack.pop();
				System.out.print("");
				if(ch == ')')
				{
					numOfClose++;
				}
				else
				{
					numOfClose--;
					if(numOfClose<0)
					{
						break;
					}
				}
			}
			if( numOfClose ==0 )
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		

		}

	}
}
