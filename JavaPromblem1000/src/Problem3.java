import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
				else if(command.equals("type"))
				{
					type();
				}
				else if(command.equals("find"))
				{
					find();
				}
				else if(command.equals("find2"))
				{
					find2();
				}
				else if(command.equals("cd"))
				{
					cd();
				}else
				{ 
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
			System.out.println(++i+". "+it.next());
		}
	}  // history
	public static void dir() { 
		String pattern = ""; 

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
			pattern = pattern.toUpperCase();
			pattern = pattern.replace(".", "\\.");
			pattern = pattern.replace("*", ".*");
			pattern = pattern.replace("?", ".{1}");

			Pattern p = Pattern.compile(pattern);

			for(File f : curDir.listFiles()){
				String tmp = f.getName().toUpperCase();
				Matcher m = p.matcher(tmp);

				if(m.matches()){
					if(f.isDirectory()){
						System.out.println("["+f.getName()+"]");	
					}else{
						System.out.println(f.getName());
					}
				}
			}

			break;

		default :
			System.out.println("Usage : dir [FileName]");

		} // dir
	}


	public static void  type() throws IOException {
		if(str_Array.length !=2){
			System.out.println("Usage : type FILE_NAME");
			return ;
		}

		String fileName = str_Array[1];

		File tmp = new File(curDir ,fileName);
		if(tmp.isFile())
		{
			FileReader fr = new FileReader(tmp);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			for(; (line=br.readLine()) != null ; ){
				System.out.println(line);			

				fr.close();
				br.close();
			}
		}else if(tmp.isDirectory())
		{
			System.out.println(fileName + " is a directory file.");
		}else{
			System.out.println(fileName + " is not existed.");		
		}

		return; 
	} // type
	public static void find() throws IOException{
		if(str_Array.length != 3)
		{
			System.out.println("USAGE : find KEYBOARD FILE_NAME");
			return;
		}

		String keyword = str_Array[1];
		String fileName = str_Array[2];

		File tmp = new File(curDir ,fileName);

		if(tmp.isFile())
		{
			FileReader fr = new FileReader(tmp);
			BufferedReader br = new BufferedReader(fr);

			String line = "";

			for(int count=1 ; (line=br.readLine()) != null ; count++){
				if(line.contains(keyword))
					System.out.println(count+":"+line);		
			}

			fr.close();
			br.close();
		}
		else if(tmp.isDirectory())
		{
			System.out.println(fileName + " is a directory file.");
		}else{
			System.out.println(fileName + " is not existed.");		
		}

		return;
	}
	public static void find2() throws IOException{
		if(str_Array.length != 3){
			System.out.println("USAGE : find2KEYWORD FILE_NAME");
			return;
		}

		String keyword = str_Array[1];
		String pattern = str_Array[2];
		pattern = pattern.toUpperCase(); 
		pattern = pattern.replace(".", "\\.");
		pattern = pattern.replace("*", ".*");
		pattern = pattern.replace("?", ".{1}");


		//		File tmp = new File(curDir ,fileName);

		Pattern p = Pattern.compile(pattern);

		for(File f : curDir.listFiles()){
			String tmp = f.getName().toUpperCase();
			Matcher m = p.matcher(tmp);

			
			
			if(m.matches()){
				if(f.isFile())
				{
					FileReader fr = new FileReader(tmp);
					BufferedReader br = new BufferedReader(fr);

					String line = "";
					System.out.println("-----------------------"+f.getName());	
					for(int count=1 ; (line=br.readLine()) != null ; count++){
						if(line.contains(keyword))
							System.out.println(count+":"+line);		
					}

					fr.close();
					br.close();
				}
				else if(f.isDirectory())
				{
					System.out.println(f.getName() + " is a directory file.");
				}else{
					System.out.println(f.getName() + " is not existed.");		
				}
			}
		}
		return;
	}
	public static void cd(){
		if(str_Array.length ==1){
			System.out.println(curDir);
			return;
		}
		else if(str_Array.length > 2){
			System.out.println("USAGE : cd directory");
			return;
		}
		
		String subDir = str_Array[1];
		
		if(subDir.equals(".."))
		{
			curDir = curDir.getParentFile();
		}
		else if(subDir.equals("."))
		{
		}
		else{
			for(File i : curDir.listFiles())
			{
				if(i.getName().equals(subDir))
				{
					if(i.isDirectory())
					{
						File tmp = new File(curDir ,subDir);
						curDir = tmp;
						System.out.println(curDir.getPath());
					}
					else
					{
						System.out.println("���͸� ������ �ƴմϴ�.");
					}
				}
			}
		}
		
	}
}// class 
