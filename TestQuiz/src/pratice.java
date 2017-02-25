import java.util.ArrayList;
import java.util.Arrays;

/**
 * Object - toString : 문자열 정보를 리턴
 */
public class pratice {
   public static void main(String[] args) {
	   ArrayList<String> arr = new ArrayList<>();
	   arr.add("a");
	   arr.add("g");
	   arr.add("z");
	   arr.add("q");
	   arr.sort(arr);
	   System.out.println(Arrays.toString(arr.toArray()));
	   System.out.println(arr.toString()); 
	   System.out.println(arr); // arr을 출력시 .toString() 메서드 리턴.
	   for(int i=0 ; i<arr.size()-1 ;i++)
	   {
		   for(int j=0 ; j<arr.size()-1 ; j++)
		   {
			   if(arr.get(j).charAt(0)>arr.get(j+1).charAt(0));
			   {
				   // ArrayList의 set 메서드를 사용해서 바꿀 인덱스에 string을 넣어서 바꿔주면 됨.
			   }
		   }
	   }
	   
   }

}