package duplicatedClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
class Comparator_fail { 
	public static void main(String[] args) { 
		ArrayList<Student> list = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);

		int num =sc.nextInt();

		for(int i=0; i<num ; i++)
		{
			list.add((new Student(sc.nextInt(), sc.nextInt(), i+1)));
		}
		calculateRank(list);
		
		Collections.sort(list, new ClassStudentNoComparator());
		for(Student e : list)
		{
			e.Print();
		}
	} 


	public static void calculateRank(List<Student> list) {
		Collections.sort(list);
		
		int prevWeight = list.get(0).getWeight();
		int prevKey = list.get(0).getKey();

		int prevRank = 1;

		int i=0;

		for(Student s : list)
		{
			if( (s.getWeight() > prevWeight && s.getKey() < prevKey) || 
					(s.getWeight() < prevWeight && s.getKey() > prevKey) || 
					(s.getWeight() == prevWeight && s.getKey() == prevKey) )
			{ 
				s.grade = prevRank; 
			} else { 
				s.grade = i + 1; 
			} 
			prevRank = s.grade; 
			prevWeight = s.weight;
			prevKey = s.key;
			i++;
		}

	}



} 

class Student implements Comparable<Student>{ 

	int Id ;
	int weight;
	
	
	public Student(int weight, int key, int Id)
	{
		this.weight = weight;
		this.key =key;
		this.Id = Id;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	int key;
	int grade = 0;

	@Override
	public int compareTo(Student obj){
		if( (this.weight > obj.weight && this.key > obj.key) || (this.weight == obj.weight && this.key > obj.key) ||
				(this.weight > obj.weight && this.key == obj.key))
			return -1;
		else if( (this.weight < obj.weight && this.key < obj.key) || (this.weight < obj.weight && this.key == obj.key) ||
				(this.weight == obj.weight && this.key < obj.key))
			return 1;
		else
			return 0;
	}
	public void Print()
	{
		System.out.print(this.grade+" ");
	}
}
class ClassStudentNoComparator implements Comparator<Student> { 
	public int compare(Student s1, Student s2) { 	
		if(s1.Id > s2.Id)
			return 1;
		else
			return -1;
	} 
}

