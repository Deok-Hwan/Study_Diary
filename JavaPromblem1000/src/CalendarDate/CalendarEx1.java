package CalendarDate;

import java.util.Calendar;
import java.util.Date;

public class CalendarEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�⺻������ ���� ��¥�� �ð����� �����ȴ�.
		Calendar today = Calendar.getInstance();
		System.out.println("�� ���� �⵵ : "+today.get(Calendar.YEAR));
		System.out.println("�� (0~11, 0:1 1��" + today.get(Calendar.MONTH));
		System.out.println("�� ���� �� ° �� : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("�� ���� �� ° ��  : "+today.get(Calendar.WEEK_OF_MONTH));
		
		//Date�� DAY_OF_MONTH�� ����.
		System.out.println("�� ���� �� �� : "+ today.get(Calendar.DATE));
		System.out.println("�� ���� �� ��" + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("�� ���� �� ��" + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("���� (1~7, 1: �Ͽ���"
				+ today.get(Calendar.DAY_OF_WEEK)); // 1: �Ͽ��� , 2: ������, ... 7: �����
		System.out.println("�� ���� �� ° ����"
				+ today.get(Calendar.DAY_OF_WEEK_IN_MONTH)); // �� ���� �׹�° ������
		System.out.println("����_����(0:����, 1:����) : "+today.get(Calendar.AM_PM));
		System.out.println("�ð�(0~11) : " + today.get(Calendar.HOUR));
		System.out.println("�ð�(0~23) : " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("��(0~59) : " +today.get(Calendar.MINUTE));
		System.out.println("��(0~59) : " +today.get(Calendar.SECOND));
		System.out.println("1000���� 1��(0~999) : " + today.get(Calendar.MILLISECOND));
		System.out.println("�� ���� ������ �� : " + today.getActualMaximum(Calendar.DATE)); 
		// �� ���� ������ ���� ã�´�.
		
	
		
	}
	/**
	 *  Date�� Calendar ���� ��ȯ 
	 */
	static void func1() {
		// Calendar�� Date�� ��ȯ
		Calendar cal = Calendar.getInstance();
		Date d = new Date(cal.getTimeInMillis()) ; ; // Date(long date)
		
		// Date�� Calendar�� ��ȯ
		Date d1 = new Date();
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(d1);
		
	}

}
