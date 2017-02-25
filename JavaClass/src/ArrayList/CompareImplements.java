package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompareImplements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Man1> a = new ArrayList<>();
		
		Collections.sort(a, new Comparator<Man1>(){ // <Man1>�� �ۼ��ؾ��Ѵ�. 
			@Override
			public int compare(Man1 o1, Man1 o2) {
			
				return o1.age - o2.age; // 1. ���̸� �������� ��������
				
			}
		});
		
	}

}
class Man implements Comparable<Man> { // �񱳱��� �������̽�.
	String name = "";
	int age;
	public Man(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name+":"+age+"��";
	}
	/** ���������� ����
	 * ���ǰ� ���� �Ķ���Ͱ��� ũ��  -1 (����)
	 * ���ǰ� ���� �Ķ���Ͱ��� ������ +1 (���)
	 * ������ 0
	 */
	@Override
	public int compareTo(Man o) { 
		// 1. ���� ���� ��������  : this.age - age;
		// 2. ���� ���� �������� : age - this.age
		
		// 3. �̸� ���� �������� : return this.name.compareTo(o.name); �޼ҵ� ȣ��
		// 4. �̸� ���� �������� : return -this.name.compareTo(o.name); 
		
		return this.age - age; 
	}
}
class Man1 
{
	String name = "";
	int age;
	public Man1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name+":"+age+"��";
	}
}
