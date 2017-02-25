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


			// 1. 화면을 통해 사용자의 입력을 받는다.(Scanner클래스 사용)
			Scanner sc = new Scanner(System.in);
			String str = sc.next();

			if(str =="q" || str== "Q"){ break;}
			if(str.equals(answer) || str.equals(answer.toLowerCase())){
				System.out.println(answer+"정답입니다.");
				break;
			}
			else
			{
				System.out.println(answer+"는 정답이 아닙니다. 다시 시도하세요."); 	
				System.out.println("Hint : "+getHint(answer, hint));
			}
			// 2. 사용자가 q 또는 Q를 입력하면 프로그램을 종료한다.

			// 3. 사용자가 정답을 맞출때까지 반복하다가 

			//     사용자가 정답을 맞추면, while문을 빠져나간다.

		} // while 

	} // end of main 

	public static String getAnswer(String[] strArr) { 
		// 내용을 완성하세요.
		int ranValue = (int)(Math.random()*strArr.length );
		return strArr[ranValue];

	} 

	public static String getScrambledWord(String str) { 
		// 내용을 완성하세요.
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

		// 1. 반복문을 이용해서 hint에 포함된 '_'의 개수를 센다.

		// 2. count의 값이 2보다 클 때만 정답의 한 글자를 hint에 넣는다.

		//    정답을 다 알려주는 상황이 되지 않게 하기 위함.


		//    [주의] 반드시 이전 힌트 보다 한글자를 더 보여줘야함.

		//    예를 들어 정답이 "LOVE"이고 이전 힌트가 "L___"이었다면

		//    그 다음 힌트는 "L__E"또는 "L_V_" 와 같은 식이어야 한다.

		//    Math.random()을 사용해서 정답의 한 글자를 골라서 힌트에 넣으면 된다.


	} // getHint() 




} 