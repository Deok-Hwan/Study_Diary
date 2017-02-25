package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<>();
		al.add("abc");
		al.add("zzz");
		al.add("ddd");
		al.add("ddd");
		System.out.println(al);
		System.out.println(al.get(1));
		Collections.sort(al);
		System.out.println(al);
	}

}