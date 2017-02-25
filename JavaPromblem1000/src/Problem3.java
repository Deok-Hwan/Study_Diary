import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

class Problem3 { 
	static String []str_Array = {}; // 입력한 매개변수를 담기 위한 문자열 배열
	static LinkedList<String> q = new LinkedList<String>(); // 사용자 입력한  내용을 저장할 큐 (QUEUE)
	static final int Max_Size = 5; // Queue에 최대 5개 까지만 저장.
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

				// 화면으로부터 라인단위로 입력받는다.
				String input = sc.nextLine();

				String command = "";
				save(input);

				input = input.trim();
				str_Array = input.split(" +");

				command = str_Array[0];

				if("".equals(command)) continue;
				command = command.toLowerCase(); //명령어를 소문자로 바꾼다.

				if(input.equals("q")) { // q 또는 Q를 입력하면 실행종료한다. 
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
					/* 위의 코드를 향상된 for문으로 변경하면 다음과 같다.
                 for(String arg : argArr) { 
                       System.out.println(arg);                                                       
                 } 
					 */
				} // if 
			}catch(Exception e){
				//System.out.println("입력 오류 입니다.");
				e.printStackTrace();
			}

		} //while
	} //main
	public static void save(String input) { 

		if(input==null || "".equals(input)) return; 

		q.add(input); // queue에 저장한다.


		// queue의 최대크기를 넣으면 제일 오래된 저장값을 삭제한다. 
		if((q).size() > Max_Size) 
			q.remove(); 

	} // save

	// 사용자가 입력한 최근 명령을 보여주는 메서드
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
		case 1 :  // dir만 입력한 경우 현재 디렉토리의 모든 파일과 디렉토리를 보여준다.

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
		case 2 :  // dir과 패턴을 같이 입력한 경우, 예를 들면 dir *.class
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
						System.out.println("디렉터리 파일이 아닙니다.");
					}
				}
			}
		}
		
	}
}// class 
