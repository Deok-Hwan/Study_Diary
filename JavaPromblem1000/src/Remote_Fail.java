import java.util.Scanner;

public class Remote_Fail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int []buttonNumber = {0,1,2,3,4,5,6,7,8,9};

		int chennelNumber = sc.nextInt(); // ���ϴ� ü��
		int currentChannel = chennelNumber;  		  // ���� ü��

		int []arrChannelNumber = new int[10]; // ���ϴ� ü���� �迭ȭ
		for(int i=0 ; i<10 ; i++){arrChannelNumber[i] = -1;} // arrchannelnumber�� ���� -1�� �ʱ�ȭ
		int countArrChannelNumber = 0;  // �ִ� ���ڸ�
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
		int brokenNumberCount = sc.nextInt(); // ���峭 ������ ��ư�� ����

		int [] brokenNumber = new int[brokenNumberCount] ; // ���峭 ������ ��ư�� �迭ȭ


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
			buttonNumber[brokenNumber[i]] = -1; // ��� ������ ��ư���� ����, �Ұ����� ��ư�� -1�� �ʱ�ȭ
		}

		String InputButton = "";

		for(int i=countArrChannelNumber-1 ; i>-1 ; i--)
		{
			int Acn = arrChannelNumber[i];
			if(Acn == buttonNumber[Acn])
			{
				buttonCount++; // ù��° �ڸ� ��ư ������.
				InputButton = InputButton.concat(Integer.toString(Acn)); // ������ ���ڿ��� ��ȯ�ؼ� InputButton�� ����.
			}
			else
			{
				int leftside = leftSide(Acn, buttonNumber);
				int rightside = rightSide(Acn, buttonNumber);
				if(leftside == 100 &&  rightside == 100)
				{
					buttonCount = Integer.MAX_VALUE;
					break;
				} // ��� ������ ��ư�� ����. buttonCount�� �ִ���� ����
				if(Math.abs(Acn-leftside) > Math.abs(Acn-rightside) )
				{
					buttonCount++;
					InputButton = InputButton.concat(Integer.toString(rightSide(Acn, buttonNumber)));

				}  //���� ����� �ڸ��� Ȯ���ؼ� Inputbutton�� ���� (������ �� ����� ��)
				else if( Math.abs(Acn-leftside) < Math.abs(Acn-rightside))
				{  
					buttonCount++;
					InputButton = InputButton.concat(Integer.toString(leftSide(Acn, buttonNumber)));
				}  //���� ����� �ڸ��� Ȯ���ؼ� Inputbutton�� ���� (�������� �� ����� ��)
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
				} // ���� ����� �ڸ��� ���� ���� ��쿡�±� ������ �ڸ��� ���� ������ ��� �Ѵ�. ex) 50�϶� 6�� �ƴ�4�� �����ؾ���. 56�϶� 4���ƴ� 6�� �����ؾ���.
			}
		}
		System.out.println(InputButton);
		int num = Integer.parseInt(InputButton); // ���������� ��ȯ
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
