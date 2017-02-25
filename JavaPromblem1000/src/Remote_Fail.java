import java.util.Scanner;

public class Remote_Fail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int []buttonNumber = {0,1,2,3,4,5,6,7,8,9};

		int chennelNumber = sc.nextInt(); // 원하는 체널
		int currentChannel = chennelNumber;  		  // 현재 체널

		int []arrChannelNumber = new int[10]; // 원하는 체널을 배열화
		for(int i=0 ; i<10 ; i++){arrChannelNumber[i] = -1;} // arrchannelnumber을 먼저 -1로 초기화
		int countArrChannelNumber = 0;  // 최대 몇자리
		while(true){

			arrChannelNumber[countArrChannelNumber] = chennelNumber%10;
			chennelNumber = chennelNumber /10;
			countArrChannelNumber++;
			if(chennelNumber == 0)
			{
				break;
			}
		} 

		int buttonCount = 0;
		int brokenNumberCount = sc.nextInt(); // 고장난 리모컨 버튼의 개수

		int [] brokenNumber = new int[brokenNumberCount] ; // 고장난 리코컨 버튼을 배열화


		for(int i=0 ; i<brokenNumberCount ; i++)
		{
			brokenNumber [i] = sc.nextInt();
		}
		if(brokenNumberCount == 10)
		{
			System.out.println( Math.abs(currentChannel - 100) );
			return;
		}

		for(int i=0; i<brokenNumberCount ; i++)
		{
			buttonNumber[brokenNumber[i]] = -1; // 사용 가능한 버튼으로 변경, 불가능한 버튼은 -1로 초기화
		}

		String InputButton = "";

		for(int i=countArrChannelNumber-1 ; i>-1 ; i--)
		{
			int Acn = arrChannelNumber[i];
			if(Acn == buttonNumber[Acn])
			{
				buttonCount++; // 첫번째 자리 버튼 눌러줌.
				InputButton = InputButton.concat(Integer.toString(Acn)); // 정수를 문자열로 변환해서 InputButton에 저장.
			}
			else
			{
				int leftside = leftSide(Acn, buttonNumber);
				int rightside = rightSide(Acn, buttonNumber);
				if(leftside == 100 &&  rightside == 100)
				{
					buttonCount = Integer.MAX_VALUE;
					break;
				} // 사용 가능한 버튼이 없음. buttonCount를 최댓수로 변경
				if(Math.abs(Acn-leftside) > Math.abs(Acn-rightside) )
				{
					buttonCount++;
					InputButton = InputButton.concat(Integer.toString(rightSide(Acn, buttonNumber)));

				}  //가장 가까운 자리를 확인해서 Inputbutton에 저장 (왼쪽이 더 가까울 시)
				else if( Math.abs(Acn-leftside) < Math.abs(Acn-rightside))
				{  
					buttonCount++;
					InputButton = InputButton.concat(Integer.toString(leftSide(Acn, buttonNumber)));
				}  //가장 가까운 자리를 확인해서 Inputbutton에 저장 (오른쪽이 더 가까울 시)
				else
				{
					if(i==0)
					{
						if(leftside > rightside)
						{
							buttonCount++;
							InputButton = InputButton.concat(Integer.toString(rightSide(Acn, buttonNumber)));

						} 
						else
						{  
							buttonCount++;
							InputButton = InputButton.concat(Integer.toString(leftSide(Acn, buttonNumber)));
						} 
					}
					else{
						int Bcn = arrChannelNumber[i-1];
						if( Math.abs( leftSide(arrChannelNumber[i-1], buttonNumber) - Bcn) > Math.abs(rightSide(arrChannelNumber[i-1], buttonNumber)-Bcn))
						{
							buttonCount++;
							InputButton = InputButton.concat(Integer.toString(rightSide(arrChannelNumber[i], buttonNumber)));
							System.out.println("11111111111111");
						} 
						else
						{  
							buttonCount++;
							InputButton = InputButton.concat(Integer.toString(leftSide(arrChannelNumber[i], buttonNumber)));
							System.out.println("!!!!!!!!!!!!!!!!");
						} 
					}
				} // 가장 가까운 자리의 값이 같을 경우에는그 다음의 자리의 수도 생각해 줘야 한다. ex) 50일때 6이 아닌4를 선택해야함. 56일때 4가아닌 6을 선택해야함.
			}
		}
		System.out.println(InputButton);
		int num = Integer.parseInt(InputButton); // 숫자형으로 변환
		buttonCount += Math.abs(num-currentChannel);
		int ChannelCount = 0;
		ChannelCount+=Math.abs(currentChannel - 100);
		
		if(ChannelCount > buttonCount)
			System.out.println(buttonCount);
		else
			System.out.println(ChannelCount);

		sc.close();
	}



	static int leftSide(int input, int [] arr)
	{
		for(int i=input ; i>-1 ; i--)
		{
			if(arr[i] != -1)
			{
				System.out.println("33333333");
				System.out.println(arr[i]);
				return arr[i];
			}
		}
		return 100;
	}
	static int rightSide(int input, int [] arr)
	{	
		for(int i=input ; i<10 ; i++)
		{
			if(arr[i] != -1)
			{
				return arr[i];
			}
		}
		return 100;
	}


}
