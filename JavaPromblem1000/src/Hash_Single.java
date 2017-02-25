/**
 * 
 * @HashCode, @singleTon
 *	
 */
public class Hash_Single {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Student1 s3 = new Student1(1202,"������",100,50);
		//System.out.println(s3.hashCode()); // ������ ��ü�� �ּҷ� �ؽ��ڵ尪�� ������ �ش�.(ObjectŬ����)
	
		DB d = DB.getInstance();
		System.out.println(d.toString());
	}
	public static void pp(){
		DB d = DB.getInstance();
		System.out.println(d);
	}
	// 1. ���빰�� ���� ��ü�� hashcode�� ���� �����ؾ� �Ѵ�. �������� �ٸ��� hashcode ���� �޶�����.
	//   -Object Ŭ������ hashCode() �� ��ü�� �ּҷ� hashCode �� ����, ��ü ���� ���� �ٸ���.
	//   -String Ŭ������ hashCode() �� ���ڿ��� �������� hashCode �� ���� 
	//	  		 ���ڿ��� ������ ������ �ٸ� ��ü�� ������ hashCode ���� ����
	// 2. ���� ��ü�� ������ ������ hashCode ���� ���ϵǾ�� �Ѵ�.
	// 3. �ٸ� ������ ����ִ� �� ��ü�� hashCode ���� �� �ٸ� �ʿ�� ����.
	// 		hashCode ���� �ٸ��� ������ ��������.
	
}	// end of class
class Student1
{
	int num; // �й�
	String name= "";
	int kor;
	int eng;
	public Student1()
	{}
	public Student1(int num, String name, int kor, int eng){	
	}
	
	@Override
	public int hashCode() {  // String Ŭ������ hashCode()�� Ȱ��
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
		public static DB getInstance() { // ��ü ������ ������ش�. 1���� ��ü�� �����ȴ�.
			if(db == null){
			db = new DB();
			}
			return db;
		}
}