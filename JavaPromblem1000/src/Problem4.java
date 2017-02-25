import java.util.*;

class Problem4 { 
	static final int Math =1;
	static final int Eng = 2;
	static final int Kor = 3;
	static final int Total =4;
	static final int SchoolRank = 5;
	static final int FindStudent = 6;

	public static void main(String[] args) { 
		ArrayList<Student> list = new ArrayList<Student>(); 
		Scanner sc = new Scanner(System.in);
		
		//                  �̸�,    ��, ��ȣ, ����, ����, ���� 
		
		list.add(new Student("�ڴ�ȯ", 3,2,100,100,100)); 
		list.add(new Student("������", 3,1,90,100,80)); 
		list.add(new Student("������", 3,3,70,100,100)); 
		list.add(new Student("�̻��ؾ�", 3,4,100,50,10)); 
		list.add(new Student("�̻��ز�", 3,5,90,40,10)); 
		list.add(new Student("���ڸ�", 3,6,70,30,60)); 
		list.add(new Student("ĳ����", 3,7,100,50,100)); 
		list.add(new Student("��ħ��", 3,8,90,10,80)); 
		list.add(new Student("�ߵ���", 3,9,70,16,0)); 
		
		list.add(new Student("�ݻ��", 1,2,60,70,60)); 
		list.add(new Student("��ī��", 1,1,60,40,70)); 
		list.add(new Student("������", 1,3,70,30,60)); 
		list.add(new Student("��ٸ�", 1,4,80,60,90)); 
		list.add(new Student("����", 1,5,60,100,70)); 
		list.add(new Student("��Ʈ��", 1,6,70,80,60)); 
		
		list.add(new Student("���̸�", 2,1,50,80,100)); 
		list.add(new Student("���α�", 2,3,70,80,60)); 
		list.add(new Student("������", 2,4,80,80,85)); 
		list.add(new Student("������", 2,2,40,20,60)); 
		list.add(new Student("�ĵ�", 2,5,50,50,100)); 
		list.add(new Student("�ϵ���", 2,6,70,60,60)); 
		list.add(new Student("�߻�", 2,7,80,10,85)); 
		list.add(new Student("Ǫ��", 2,8,40,45,60)); 
		
		calculateSchoolRank(list); // ���� ���
		calculateClassRank(list); // �� ���
		printList(list);
		
		while(true)
		{
			System.out.println("1. ���� ������ , 2. ���� ������, 3. ���� ������, 4. ���� ������. 5. ���� �����,  6. �л� �˻� , 7. ����");
			int num = sc.nextInt();
			if(num == 7)break;
			PrintScore(list, num);
			printList(list);	
		}
	} 
	public static void printList(List<Student> list) { 
		System.out.println("�̸�\t��\t��ȣ\t����\t����\t����\t����\t������� \t�ݵ��"); 
		System.out.println("================================================================="); 

		for(Student s : list) { 
			System.out.println(s); 
		} 

		System.out.println("================================================================="); 

	} 

	public static void calculateSchoolRank(List<Student> list) { 
		Collections.sort(list); // ���� list�� �������� ������������ �����Ѵ�.

		int prevRank = 0;       // ���� �������
		int prevTotal = 301;       // ���� ���� , �ʱⰪ�� ���� ū �� +1
		int NowRank = 1; 
		
		
		for(Student s : list){
			if(s.getTotal()<prevTotal)
			{
				prevTotal = s.getTotal();
				s.setSchoolRank(NowRank);
				prevRank = NowRank;
			}
			else //total ���� ���ٸ�
			{
				s.setSchoolRank(prevRank);
			}
			NowRank++;

		}
	} // public static void calculateSchoolRank(List list)
	public static void calculateClassRank(List<Student> list) {
		Collections.sort(list, new ClassTotalComparator()); // ��, ���� ����  ����

		int prevClassNo = list.get(0).getClassNo(); //����Ʈ�� ù��° ���� �� ��ȣ�� �ʱⰪ���� ����
		int prevRank = -1;
		int prevTotal = -1;
		int i=0; // ������ Rank

		for(Student s : list)
		{
			if(s.getClassNo() == prevClassNo){ // ���� ���̶�� �б�

				if(s.total==prevTotal) { 
					s.classRank = prevRank; 
					
				} else { 
					s.classRank = i + 1;  
					
				} 

				prevRank = s.classRank; 
				prevTotal = s.total; 
				i++;

			} 

			else // �ٸ� ���̶��
			{
				i=0; // �ٽ�  i ���� 0 ���� �ʱ�ȭ 
				s.classRank = i+1; // ���� �ٲ�� �� ���� ������ 1���̹Ƿ� classRank�� 1�� set.
				prevClassNo = s.getClassNo(); //�� ��ȣ�� �ʱ�ȭ
				prevRank = -1;
				prevTotal = -1;
				i++;
			}

		}

	}
	public static void PrintScore(List<Student> list, int Subject)
	{
		Scanner sc= new Scanner(System.in);
		switch(Subject){

		case Math : {
			Collections.sort(list, new ClassStudentMathComparator());
			break;
		}
		case Eng :{
			Collections.sort(list, new ClassStudentEngComparator());
			break;
		}
		case Kor : {
			
			Collections.sort(list, new ClassStudentKorComparator());
			break;
		}
		case Total :{
			Collections.sort(list, new ClassStudentTotalComparator());
			break;
		}
		case SchoolRank :{
			Collections.sort(list, new ClassStudentSchoolRankComparator());
			break;
		}
		case FindStudent :{
			String str = "";
			str = sc.nextLine();
			for(Student s : list)
			{
				if(s.name.equals(str))
				{
					System.out.println(s);
					return;
				}
			}
			System.out.println("�л��� �����ϴ�.");
			break;
		}
		

		}
	} 
}
class Student implements Comparable<Student>{ 

	final static int LEFT = 0;
	final static int CENTER = 1;
	final static int RIGHT = 2;


	String name = "";

	int ClassNo;
	int num;
	int NatScore;
	int MathScore;
	int EngScore;
	int total;

	int classRank = 0; // �� ���
	int schoolRank = 0; // ���� ���

	public Student(String name, int Class, 
			int num, int NatScore, int MathScore,  int EngScore)
	{
		this.name = name;
		this.ClassNo = Class;
		this.num = num;
		this.EngScore = EngScore;
		this.MathScore = MathScore;
		this.NatScore = NatScore;
		this.total = EngScore + NatScore + MathScore;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassNo() {
		return ClassNo;
	}
	public void setClass(int class1) {
		ClassNo = class1;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNatScore() {
		return NatScore;
	}
	public void setNatScore(int natScore) {
		NatScore = natScore;
	}
	public int getMathScore() {
		return MathScore;
	}
	public void setMathScore(int mathScore) {
		MathScore = mathScore;
	}
	public int getEngScore() {
		return EngScore;
	}
	public void setEngScore(int engScore) {
		EngScore = engScore;
	}
	public int getSchoolRank() {
		return schoolRank;
	}
	public void setSchoolRank(int schoolRank) {
		this.schoolRank = schoolRank;
	}
	public int getTotal()
	{
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() { 
		return name + "\t" 
				+ ClassNo + "\t" 
				+ num + "\t" 
				+ NatScore + "\t" 
				+ MathScore + "\t" 
				+ EngScore + "\t" 
				+ total + "\t" 
				+ schoolRank + "\t"

              + classRank + "\t";
	} 
	public int compareTo(Student obj){
		if(this.total > obj.total)
			return -1;
		else if(this.total == obj.total)
			return 0;
		else
			return 1;
	}



}
class ClassTotalComparator implements Comparator<Student> {  //�� ���� ����
	public int compare(Student s1, Student s2) { 
		int result = s1.ClassNo - s2.ClassNo; 
		if(result == 0)
			result = s2.total - s1.total;  // ���� ���ٸ� ���� ���� ����
		return result;
	} 
} 

class ClassStudentNoComparator implements Comparator<Student> { //�� ��� ����
	public int compare(Student s1, Student s2) { 	
		int result = s1.ClassNo - s2.ClassNo;

		if(result == 0)
			result = s1.num - s2.num; // �� ����� ��ȣ�� ����
		return result;
	} 
}

class ClassStudentEngComparator implements Comparator<Student> { //�������� �� ����
	public int compare(Student s1, Student s2) { 	
		return -(s1.EngScore - s2.EngScore);
	} 
}
class ClassStudentMathComparator implements Comparator<Student> { //�������� �� ����
	public int compare(Student s1, Student s2) { 	
		return -(s1.MathScore-s2.MathScore);
	} 
}
class ClassStudentKorComparator implements Comparator<Student> { //�������� �� ����
	public int compare(Student s1, Student s2) { 	
		return -(s1.NatScore-s2.NatScore);
	} 
}
class ClassStudentTotalComparator implements Comparator<Student> { //���� ���� �� ����
	public int compare(Student s1, Student s2) { 	
		return -(s1.total - s2.total);
	} 
}
class ClassStudentSchoolRankComparator implements Comparator<Student> { //���� ��� �� ����
	public int compare(Student s1, Student s2) { 	
		return (s1.schoolRank - s2.schoolRank);
	} 
}


