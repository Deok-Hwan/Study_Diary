import java.util.Arrays;
import java.util.Scanner;

public class ChroatiaWordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String []regx = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String replace = "*";
		int CountWord = 0;

		str = str.trim(); // 공백 + 아무것도 입력 안할시.

		int length = str.length() ;
		for(int j=0 ; j<length ;j++ ){
			for(int i=0; i<regx.length ; i++)
			{
				if(str.contains(regx[i]))
				{
					CountWord++;
					str = str.replaceFirst(regx[i], replace);
					//크로아티아 알파벳이 있을시 단어를 제거하고 count를 증가 시킨다.
				}
			}
		}
		for(int i=0 ; i<str.length() ; i++)
		{
			if(str.charAt(i) != '*')
			{
				CountWord++;
				
			}

		}

		System.out.println(CountWord);
	}
}
