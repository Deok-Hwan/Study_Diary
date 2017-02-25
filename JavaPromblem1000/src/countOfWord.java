import java.util.Scanner;
 
public class countOfWord {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
         
        int rslt = 0;
        String s = sc.nextLine();
         
        String word = "";
        for(int i = 0; i < s.length(); i++)  {
            String c = String.valueOf(s.charAt(i));
            if(c.equals(" "))   {
                word = "";
            }else   {
                if(word.length() == 0)  {
                    rslt++;
                }
                word = c;
            }
        }
 
        System.out.println(rslt);
 
    }
 
}
 