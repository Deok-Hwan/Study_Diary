import java.util.Scanner;

public class Paint {
	public static void main()
	{
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		for(int testcase = 1 ; testcase<=Tc ; testcase++)
		{
			int [][]arr = new int[10][10];
			
			int numOfColor = sc.nextInt();
			for(int i=0 ; i<numOfColor ; i++)
			{
				int row1 = sc.nextInt();
				int col1 = sc.nextInt();
				int row2 = sc.nextInt();
				int col2 = sc.nextInt();
				int color = sc.nextInt();
				for(int j=row1 ; j<=row2 ; j++)
				{
					for(int k=col1 ; k<col2 ; k++)
					{
						arr[j][k] |= color; // 여러분 누적은 무시
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[i][j] == 3){
						
					}
				}
				
			}
			System.out.println("#"+testcase+" "+cnt);
		}
	
		
	}
}

