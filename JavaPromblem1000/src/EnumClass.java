/**
 * 
 * ������
 * ������ ǥ���ϴ� ���
 */
enum Week
{
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	// �� Ÿ���� �ʱⰪ�� NULL;
}

public class EnumClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final float PI = 3.141592f;
		System.out.println(PI * 3);
		
		Week day = Week.THURSDAY;
		Week today2 = Week.SUNDAY;
		Week Tomorrow = Week.TUESDAY;
		
		if(day == today2){
			System.out.println(day.ordinal());
		}
		if(day.equals(today2)) System.out.println();
//		System.out.println(day.name());
//		System.out.println(day.toString());
		System.out.println(day.ordinal()); // ��ü�� INDEX ���� ����
//		System.out.println(day.compareTo(Tomorrow)); // index�� ���� ���̸� ����
//		
	}
}
