import java.io.File;
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
				else { 
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
			System.out.println(++i+','+it.next());
		}
	}  // history
	public static void dir() { 
		String pattern = ""; 
		File [] files = curDir.listFiles();
		
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
			pattern = pattern.toUpperCase(); // 패턴에서 대소문자를 구별하지 않도록 대문자로 변경한다.
			System.out.println(pattern);
			Pattern p = Pattern.compile("[*].CLASS");
			
			for(int i=0; i<files.length ; i++)
			{	
				Matcher m = p.matcher(files[i].getName());
				if(m.matches())
					System.out.println(files[i].getName());	
			}
			
			/*

                       다음의 코드를 완성하세요.

                       1. 입력된 패턴(pattern)을 정규식 표현(Regular Expression)에 알맞게 치환한다.

                           String클래스의 String replace(CharSequence target, CharSequence replacement)를 사용하자.

                           예를 들면, pattern = pattern.replace("A","AA")는 pattern의 "A"를 "AA"로 치환한다.



                       2. 반복문을 이용해서 현재 디렉토리 중, 입력된 패턴과 일치하는 것들만 출력한다.

                          이때, 조건문을 같이 사용해서 디렉토리(폴더)인 경우, 이름의 앞뒤에 '[' 와 ']'를 붙여서 출력한다.

                          (File클래스의 isDirectory()를 사용해서 체크)



                          대소문자구별을 하지 않기 위해서, 패턴과 마찬가지로 파일이나 디렉토리명을 대문자로 변경해야한다.

                          String tmp = f.getName().toUpperCase(); 



			 */
			break; 
		default : 
			System.out.println("USAGE : dir [FILENAME]"); 
		} // dir


	} // main 
}// class 
