/**
 * 
 * @HashCode, @singleTon
 *	
 */
public class Hash_Single {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Student1 s3 = new Student1(1202,"김지혜",100,50);
		//System.out.println(s3.hashCode()); // 각각의 객체의 주소로 해시코드값을 생성해 준다.(Object클레스)
	
		DB d = DB.getInstance();
		System.out.println(d.toString());
	}
	public static void pp(){
		DB d = DB.getInstance();
		System.out.println(d);
	}
	// 1. 내용물이 같은 객체는 hashcode의 값은 동일해야 한다. 참조값이 다르면 hashcode 값은 달라진다.
	//   -Object 클래스의 hashCode() 는 객체의 주소로 hashCode 를 생성, 객체 마다 값이 다르다.
	//   -String 클래스의 hashCode() 는 문자열의 내용으로 hashCode 를 생성 
	//	  		 문자열의 내용이 같으면 다른 객체라도 동일한 hashCode 값을 리턴
	// 2. 같은 객체를 넣으면 동일한 hashCode 값이 리턴되어야 한다.
	// 3. 다른 내용이 들어있는 두 객체는 hashCode 값이 꼭 다를 필요는 없다.
	// 		hashCode 값이 다르면 성능이 좋아진다.
	
}	// end of class
class Student1
{
	int num; // 학번
	String name= "";
	int kor;
	int eng;
	public Student1()
	{}
	public Student1(int num, String name, int kor, int eng){	
	}
	
	@Override
	public int hashCode() {  // String 클래스의 hashCode()를 활용
		String result = num + name + kor + eng;
		// TODO Auto-generated method stub
		return result.hashCode();
		
	}
	
}
class DB{ //
		private static DB db;
		
		public DB() {
			// TODO Auto-generated constructor stub
		}
		public static DB getInstance() { // 객체 생성을 대신해준다. 1개의 객체만 생성된다.
			if(db == null){
			db = new DB();
			}
			return db;
		}
}