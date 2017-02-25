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
		
		//                  이름,    반, 번호, 국어, 수학, 영어 
		
		list.add(new Student("박덕환", 3,2,100,100,100)); 
		list.add(new Student("조보람", 3,1,90,100,80)); 
		list.add(new Student("김찬현", 3,3,70,100,100)); 
		list.add(new Student("이상해씨", 3,4,100,50,10)); 
		list.add(new Student("이상해꽃", 3,5,90,40,10)); 
		list.add(new Student("리자몽", 3,6,70,30,60)); 
		list.add(new Student("캐터피", 3,7,100,50,100)); 
		list.add(new Student("독침붕", 3,8,90,10,80)); 
		list.add(new Student("야도란", 3,9,70,16,0)); 
		
		list.add(new Student("반상수", 1,2,60,70,60)); 
		list.add(new Student("피카츄", 1,1,60,40,70)); 
		list.add(new Student("라이츄", 1,3,70,30,60)); 
		list.add(new Student("사다리", 1,4,80,60,90)); 
		list.add(new Student("꼬렛", 1,5,60,100,70)); 
		list.add(new Student("케트라", 1,6,70,80,60)); 
		
		list.add(new Student("파이리", 2,1,50,80,100)); 
		list.add(new Student("꼬부기", 2,3,70,80,60)); 
		list.add(new Student("버터플", 2,4,80,80,85)); 
		list.add(new Student("라이플", 2,2,40,20,60)); 
		list.add(new Student("후딘", 2,5,50,50,100)); 
		list.add(new Student("니도란", 2,6,70,60,60)); 
		list.add(new Student("삐삐", 2,7,80,10,85)); 
		list.add(new Student("푸린", 2,8,40,45,60)); 
		
		calculateSchoolRank(list); // 전교 등수
		calculateClassRank(list); // 반 등수
		printList(list);
		
		while(true)
		{
			System.out.println("1. 수학 성적순 , 2. 영어 성적순, 3. 국어 성적순, 4. 총점 성적순. 5. 전교 등수순,  6. 학생 검색 , 7. 종료");
			int num = sc.nextInt();
			if(num == 7)break;
			PrintScore(list, num);
			printList(list);	
		}
	} 
	public static void printList(List<Student> list) { 
		System.out.println("이름\t반\t번호\t국어\t수학\t영어\t총점\t전교등수 \t반등수"); 
		System.out.println("================================================================="); 

		for(Student s : list) { 
			System.out.println(s); 
		} 

		System.out.println("================================================================="); 

	} 

	public static void calculateSchoolRank(List<Student> list) { 
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.

		int prevRank = 0;       // 이전 전교등수
		int prevTotal = 301;       // 이전 총점 , 초기값은 가장 큰 값 +1
		int NowRank = 1; 
		
		
		for(Student s : list){
			if(s.getTotal()<prevTotal)
			{
				prevTotal = s.getTotal();
				s.setSchoolRank(NowRank);
				prevRank = NowRank;
			}
			else //total 값이 같다면
			{
				s.setSchoolRank(prevRank);
			}
			NowRank++;

		}
	} // public static void calculateSchoolRank(List list)
	public static void calculateClassRank(List<Student> list) {
		Collections.sort(list, new ClassTotalComparator()); // 반, 점수 별로  정렬

		int prevClassNo = list.get(0).getClassNo(); //리스트의 첫번째 값의 반 번호를 초기값으로 지정
		int prevRank = -1;
		int prevTotal = -1;
		int i=0; // 현재의 Rank

		for(Student s : list)
		{
			if(s.getClassNo() == prevClassNo){ // 같은 반이라면 분기

				if(s.total==prevTotal) { 
					s.classRank = prevRank; 
					
				} else { 
					s.classRank = i + 1;  
					
				} 

				prevRank = s.classRank; 
				prevTotal = s.total; 
				i++;

			} 

			else // 다른 반이라면
			{
				i=0; // 다시  i 값을 0 으로 초기화 
				s.classRank = i+1; // 반이 바뀌면 그 값은 무조건 1등이므로 classRank를 1로 set.
				prevClassNo = s.getClassNo(); //반 번호로 초기화
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
			System.out.println("학생이 없습니다.");
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

	int classRank = 0; // 반 등수
	int schoolRank = 0; // 전교 등수

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
class ClassTotalComparator implements Comparator<Student> {  //반 별로 정렬
	public int compare(Student s1, Student s2) { 
		int result = s1.ClassNo - s2.ClassNo; 
		if(result == 0)
			result = s2.total - s1.total;  // 반이 같다면 점수 별로 정렬
		return result;
	} 
} 

class ClassStudentNoComparator implements Comparator<Student> { //반 등수 정렬
	public int compare(Student s1, Student s2) { 	
		int result = s1.ClassNo - s2.ClassNo;

		if(result == 0)
			result = s1.num - s2.num; // 반 등수내 번호로 정렬
		return result;
	} 
}

class ClassStudentEngComparator implements Comparator<Student> { //영어점수 순 정렬
	public int compare(Student s1, Student s2) { 	
		return -(s1.EngScore - s2.EngScore);
	} 
}
class ClassStudentMathComparator implements Comparator<Student> { //수학점수 순 정렬
	public int compare(Student s1, Student s2) { 	
		return -(s1.MathScore-s2.MathScore);
	} 
}
class ClassStudentKorComparator implements Comparator<Student> { //국어점수 순 정렬
	public int compare(Student s1, Student s2) { 	
		return -(s1.NatScore-s2.NatScore);
	} 
}
class ClassStudentTotalComparator implements Comparator<Student> { //총점 점수 순 정렬
	public int compare(Student s1, Student s2) { 	
		return -(s1.total - s2.total);
	} 
}
class ClassStudentSchoolRankComparator implements Comparator<Student> { //전교 등수 순 정렬
	public int compare(Student s1, Student s2) { 	
		return (s1.schoolRank - s2.schoolRank);
	} 
}


