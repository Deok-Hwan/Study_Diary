import java.util.Scanner;

class Problem2 { 
	public static void main(String[] args) { 
		String[] data = { 
				"���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public", 
				"���� �� �ڹ��� �����ڰ� �ƴ� ����?`5`&`|`++`!=`/`^", 
				"���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false", 
		}; 
		String [][]div = new String[data.length][];
		String []d = {};
		int Ans[] = {2, 6, 1};
		int Sol[] = new int[3];
		
		Scanner sc = new Scanner(System.in);
		int Reserved_Count = 0;
		
		shuffle(data);
		
		for(int i=0;i<data.length;i++) {

			// 1. StringŬ������ String[] split(String regex, int limit)�� ����ؼ� ������ �������� ��������.
			div[i] = data[i].split("'");
		}     	
		for(int i=0;i<data.length;i++) {

			// 1. StringŬ������ String[] split(String regex, int limit)�� ����ؼ� ������ �������� ��������.
			d = div[i][0].split("`");

			System.out.println(d[0]); // ���� ���

			for(int j=2 ; j<d.length ; j++)
			{
				System.out.print("["+(j-1)+"]"+" "+d[j]+" ");

			}
			System.out.println();
			System.out.print("�� :");

			int num = sc.nextInt();
			Sol[i] = num;
		}
		for(int i=0 ;i<Sol.length ; i++)
			if(Sol[i] == Ans[i])
				Reserved_Count++;

		System.out.println("���� ���� �� :"+Reserved_Count);




		// 2. ������ ����ϼ���.

		// 3. �������� ������ ���� String[] split(String regex)�� ����ϼ���.

		// 4.�ݺ����� �̿��ؼ� �������� ����ϼ���.
	} 
	public static void shuffle(String[] data) { 
		
		for(int i=0 ; i<data.length * 2  ; i++)
		{
			int num = (int)( Math.random()*data.length);
		
			String str = data[0];
			data[0] = data[num];
			data[num] =str;
			
		}
		//  1. �迭data�� ������ 0���� ���ų� ������ �޼��� ��ü�� ����������.

		//  2. �������� ������ �ڹٲ۴�. �ݺ����� Math.random()���
	} // shuffle() 





} // main 


