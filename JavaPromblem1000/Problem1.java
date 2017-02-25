import java.util.*;

class Problem1 { 
	public static void main(String[] args) { 
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 


		String answer = getAnswer(strArr); 
		String question = getScrambledWord(answer);
		char []hint = new char[answer.length()];
		for(int i=0; i<hint.length; i++){
			hint[i]='_';
		}

		while(true) { 
			System.out.println("Question :" + question); 
			System.out.print("Your answer is :"); 


			// 1. ȭ���� ���� ������� �Է��� �޴´�.(ScannerŬ���� ���)
			Scanner sc = new Scanner(System.in);
			String str = sc.next();

			if(str =="q" || str== "Q"){ break;}
			if(str.equals(answer) || str.equals(answer.toLowerCase())){
				System.out.println(answer+"�����Դϴ�.");
				break;
			}
			else
			{
				System.out.println(answer+"�� ������ �ƴմϴ�. �ٽ� �õ��ϼ���."); 	
				System.out.println("Hint : "+getHint(answer, hint));
			}
			// 2. ����ڰ� q �Ǵ� Q�� �Է��ϸ� ���α׷��� �����Ѵ�.

			// 3. ����ڰ� ������ ���⶧���� �ݺ��ϴٰ� 

			//     ����ڰ� ������ ���߸�, while���� ����������.

		} // while 

	} // end of main 

	public static String getAnswer(String[] strArr) { 
		// ������ �ϼ��ϼ���.
		int ranValue = (int)(Math.random()*strArr.length );
		return strArr[ranValue];

	} 

	public static String getScrambledWord(String str) { 
		// ������ �ϼ��ϼ���.
		int Count_Num = 0;
		boolean Check_[] = {false, false, false, false, false, false};
		String Changed_str = "";
		char ch;

		while(true)
		{
			if(Count_Num == str.length()){break;}

			int ranValue= (int)(Math.random()*str.length());
			if(Check_[ranValue]  == true)
			{
				continue;
			}
			else
			{
				ch = str.charAt(ranValue);
				Changed_str += (String.valueOf(ch));
				Check_[ranValue] = true;
				Count_Num++;

			}
		}

		return Changed_str;

	} // scramble(String str) 
	public static String getHint(String answer, char[] hint) { 
		int count = 0;
		for(int i=0; i<hint.length ;i++)
			if(hint[i] == '_') count++;
		
		while(true)
		{
			int ranValue = (int)(Math.random()*answer.length() );
			
			if(hint[ranValue] == '_')
			{
				hint[ranValue] = answer.charAt(ranValue);
				break;
			}
			if(count == 0)
				break;
		}
		return String.valueOf(hint);

		// 1. �ݺ����� �̿��ؼ� hint�� ���Ե� '_'�� ������ ����.

		// 2. count�� ���� 2���� Ŭ ���� ������ �� ���ڸ� hint�� �ִ´�.

		//    ������ �� �˷��ִ� ��Ȳ�� ���� �ʰ� �ϱ� ����.


		//    [����] �ݵ�� ���� ��Ʈ ���� �ѱ��ڸ� �� ���������.

		//    ���� ��� ������ "LOVE"�̰� ���� ��Ʈ�� "L___"�̾��ٸ�

		//    �� ���� ��Ʈ�� "L__E"�Ǵ� "L_V_" �� ���� ���̾�� �Ѵ�.

		//    Math.random()�� ����ؼ� ������ �� ���ڸ� ��� ��Ʈ�� ������ �ȴ�.


	} // getHint() 




} 