import java.util.ArrayList;
import java.util.Arrays;

/**
 * Object - toString : ���ڿ� ������ ����
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
	   System.out.println(arr); // arr�� ��½� .toString() �޼��� ����.
	   for(int i=0 ; i<arr.size()-1 ;i++)
	   {
		   for(int j=0 ; j<arr.size()-1 ; j++)
		   {
			   if(arr.get(j).charAt(0)>arr.get(j+1).charAt(0));
			   {
				   // ArrayList�� set �޼��带 ����ؼ� �ٲ� �ε����� string�� �־ �ٲ��ָ� ��.
			   }
		   }
	   }
	   
   }

}