package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompareImplements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Man1> a = new ArrayList<>();
		
		Collections.sort(a, new Comparator<Man1>(){ // <Man1>을 작성해야한다. 
			@Override
			public int compare(Man1 o1, Man1 o2) {
			
				return o1.age - o2.age; // 1. 나이를 기준으로 오름차순
				
			}
		});
		
	}

}
class Man implements Comparable<Man> { // 비교기준 인터페이스.
	String name = "";
	int age;
	public Man(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name+":"+age+"살";
	}
	/** 오름차순의 기준
	 * 나의값 보다 파라미터값이 크면  -1 (음수)
	 * 나의값 보다 파라미터값이 작으면 +1 (양수)
	 * 같으면 0
	 */
	@Override
	public int compareTo(Man o) { 
		// 1. 나이 순서 오름차순  : this.age - age;
		// 2. 나이 순서 내림차순 : age - this.age
		
		// 3. 이름 순서 오름차순 : return this.name.compareTo(o.name); 메소드 호출
		// 4. 이름 순서 오름차순 : return -this.name.compareTo(o.name); 
		
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
		return name+":"+age+"살";
	}
}
