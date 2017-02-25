import java.util.Scanner;

class Problem2 { 
	public static void main(String[] args) { 
		String[] data = { 
				"다음 중 키워드가 아닌 것은?`2`final`True`if`public", 
				"다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^", 
				"다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false", 
		}; 
		String [][]div = new String[data.length][];
		String []d = {};
		int Ans[] = {2, 6, 1};
		int Sol[] = new int[3];
		
		Scanner sc = new Scanner(System.in);
		int Reserved_Count = 0;
		
		shuffle(data);
		
		for(int i=0;i<data.length;i++) {

			// 1. String클래스의 String[] split(String regex, int limit)를 사용해서 문제와 선택지를 나누세요.
			div[i] = data[i].split("'");
		}     	
		for(int i=0;i<data.length;i++) {

			// 1. String클래스의 String[] split(String regex, int limit)를 사용해서 문제와 선택지를 나누세요.
			d = div[i][0].split("`");

			System.out.println(d[0]); // 문제 출력

			for(int j=2 ; j<d.length ; j++)
			{
				System.out.print("["+(j-1)+"]"+" "+d[j]+" ");

			}
			System.out.println();
			System.out.print("답 :");

			int num = sc.nextInt();
			Sol[i] = num;
		}
		for(int i=0 ;i<Sol.length ; i++)
			if(Sol[i] == Ans[i])
				Reserved_Count++;

		System.out.println("맞춘 정답 수 :"+Reserved_Count);




		// 2. 문제를 출력하세요.

		// 3. 선택지를 나누기 위해 String[] split(String regex)를 사용하세요.

		// 4.반복문을 이용해서 선택지를 출력하세요.
	} 
	public static void shuffle(String[] data) { 
		
		for(int i=0 ; i<data.length * 2  ; i++)
		{
			int num = (int)( Math.random()*data.length);
		
			String str = data[0];
			data[0] = data[num];
			data[num] =str;
			
		}
		//  1. 배열data의 개수가 0보다 같거나 적으면 메서드 전체를 빠져나간다.

		//  2. 선택지의 순서를 뒤바꾼다. 반복문과 Math.random()사용
	} // shuffle() 





} // main 


