import java.io.File;
import java.util.*;
import java.util.regex.*;


class Problem3 { 
	static String []str_Array = {}; // �Է��� �Ű������� ��� ���� ���ڿ� �迭
	static LinkedList<String> q = new LinkedList<String>(); // ����� �Է���  ������ ������ ť (QUEUE)
	static final int Max_Size = 5; // Queue�� �ִ� 5�� ������ ����.
	static int index = Max_Size-1;
	static boolean Cont = false;

	static File curDir;
	static {
		try{
			curDir = new File(System.getProperty("user.dir"));

		}catch(Exception e){}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) { 	
		Scanner sc = new Scanner(System.in);

		while(true) { 
			try{
				String prompt = curDir.getCanonicalPath() +  ">>"; 
				System.out.print(prompt); 

				// ȭ�����κ��� ���δ����� �Է¹޴´�.
				String input = sc.nextLine();

				String command = "";
				save(input);

				input = input.trim();
				str_Array = input.split(" +");

				command = str_Array[0];

				if("".equals(command)) continue;
				command = command.toLowerCase(); //��ɾ �ҹ��ڷ� �ٲ۴�.

				if(input.equals("q")) { // q �Ǵ� Q�� �Է��ϸ� ���������Ѵ�. 
					System.exit(0); 
				} else if(command.equals("history")) 
				{
					history();
				}
				else if(command.equals("dir"))
				{
					dir();
				}
				else { 
					for(int i=0; i < str_Array.length;i++) {  
						System.out.println(str_Array[i]);
					}
					/* ���� �ڵ带 ���� for������ �����ϸ� ������ ����.
                 for(String arg : argArr) { 
                       System.out.println(arg);                                                       
                 } 
					 */
				} // if 
			}catch(Exception e){
				//System.out.println("�Է� ���� �Դϴ�.");
				e.printStackTrace();
			}

		} //while
	} //main
	public static void save(String input) { 

		if(input==null || "".equals(input)) return; 

		q.add(input); // queue�� �����Ѵ�.


		// queue�� �ִ�ũ�⸦ ������ ���� ������ ���尪�� �����Ѵ�. 
		if((q).size() > Max_Size) 
			q.remove(); 

	} // save

	// ����ڰ� �Է��� �ֱ� ����� �����ִ� �޼���
	public static void history() {  
		int i = 0;
		Iterator<String> it = q.iterator();
		while(it.hasNext()){
			System.out.println(++i+','+it.next());
		}
	}  // history
	public static void dir() { 
		String pattern = ""; 
		File [] files = curDir.listFiles();
		
		switch(str_Array.length) { 
		case 1 :  // dir�� �Է��� ��� ���� ���丮�� ��� ���ϰ� ���丮�� �����ش�.
	
			for(File f : curDir.listFiles())
			{
				if(f.isDirectory())
				{
					System.out.println("["+f.getName()+"]");
				}else{
					System.out.println(f.getName());
				}
			}
			break; 
		case 2 :  // dir�� ������ ���� �Է��� ���, ���� ��� dir *.class
			pattern = str_Array[1]; 
			pattern = pattern.toUpperCase(); // ���Ͽ��� ��ҹ��ڸ� �������� �ʵ��� �빮�ڷ� �����Ѵ�.
			System.out.println(pattern);
			Pattern p = Pattern.compile("[*].CLASS");
			
			for(int i=0; i<files.length ; i++)
			{	
				Matcher m = p.matcher(files[i].getName());
				if(m.matches())
					System.out.println(files[i].getName());	
			}
			
			/*

                       ������ �ڵ带 �ϼ��ϼ���.

                       1. �Էµ� ����(pattern)�� ���Խ� ǥ��(Regular Expression)�� �˸°� ġȯ�Ѵ�.

                           StringŬ������ String replace(CharSequence target, CharSequence replacement)�� �������.

                           ���� ���, pattern = pattern.replace("A","AA")�� pattern�� "A"�� "AA"�� ġȯ�Ѵ�.



                       2. �ݺ����� �̿��ؼ� ���� ���丮 ��, �Էµ� ���ϰ� ��ġ�ϴ� �͵鸸 ����Ѵ�.

                          �̶�, ���ǹ��� ���� ����ؼ� ���丮(����)�� ���, �̸��� �յڿ� '[' �� ']'�� �ٿ��� ����Ѵ�.

                          (FileŬ������ isDirectory()�� ����ؼ� üũ)



                          ��ҹ��ڱ����� ���� �ʱ� ���ؼ�, ���ϰ� ���������� �����̳� ���丮���� �빮�ڷ� �����ؾ��Ѵ�.

                          String tmp = f.getName().toUpperCase(); 



			 */
			break; 
		default : 
			System.out.println("USAGE : dir [FILENAME]"); 
		} // dir


	} // main 
}// class 
