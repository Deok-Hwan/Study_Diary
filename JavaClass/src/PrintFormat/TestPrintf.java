package PrintFormat;

public class TestPrintf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[홍길동]");
		System.out.println("[ 길동]");
		System.out.println(3.141592);
		System.out.printf("%10.3f\n",3.141592); // 10.3f 의 10은 총 10칸 중에 오른쪽 정렬 , -10은 왼쪽 정렬을한다.
		System.out.println("%3c"); // 10.3f의 3은 소수점 셋째자리까지 출력한다. 
		String name = "길동";
		System.out.printf("[%-5s]\n",name);
		
		double d = 123.141592;
		String s = "apple";
		System.out.println("123456789");
		System.out.printf("%-8.2f\n",d);
		System.out.printf("%7s\n",s);
		
		System.err.println("사자");
	}

}
