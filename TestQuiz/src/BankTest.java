import java.util.LinkedList;
import java.util.Scanner;
/**
 * 
 * @�ڴ�ȯ ����ý��� 
 *  * �Ա� , ���, ������ü, �ŷ����� ��ȸ, ���� �ܾ� ��ȸ�� ����� ����� �� �ִ�.
 *
 */
public class BankTest {
	public static void main(String[] args) {
		Bank KookminBank = new Bank();
		Bank.Person p1 = new BankTest.Bank.Person("�ڴ�ȯ",0);
		
		while(true)
		{
			Scanner sc = new Scanner(System.in);

			System.out.println("--------------------------------------------------------------");
			System.out.println("*                   �������࿡ ���ּż� �����մϴ�.                    *");
			System.out.println("--------------------------------------------------------------");
			System.out.println("1. �Ա� , 2. ���, 3. ������ü , 4. �ŷ����� ��ȸ, 5. ���� �ܾ� ��ȸ, 6. ����");
			int select = sc.nextInt();
			sc.nextLine();

			if(select == 1 ) // ���ϴ� ������� �б�
			{
				System.out.println("�Ա��� �ݾ��� �־��ּ���.");
				KookminBank.deposit(p1, sc.nextInt());
			}else if(select == 2)
			{
				System.out.println("�󸶸� ����ϰڽ��ϱ�?");
				KookminBank.withdrawal(p1, sc.nextInt());
			}else if(select == 3)
			{
				System.out.println("���� ��ü�� ���� �ϰڽ��ϴ�.");
				System.out.println("���� ��ü�� �������� �����ϰڽ��ϱ�?");
				String str = sc.nextLine();
				System.out.println("�� �Ա��Ͻðڽ��ϱ�?");
				int money = sc.nextInt();
				KookminBank.transfer(p1, str, money);
			}
			else if(select ==4)
			{
				System.out.println("�ŷ� ������ ��ȸ�մϴ�.");
				KookminBank.showLog(p1);
			}
			else if(select == 5)
			{
				KookminBank.showMoney(p1);
			}
			else
			{
				System.out.println("�����մϴ�. �� �̿��� �ּ���.");
				break;
			}

		}

	}//end of main


	static class Bank
	{
		private Person p [] = { // ����ڰ� ���࿡ ����Ǿ� ����
				new Person("������",20000,"1234"), new Person("�ڴ�ȯ",10000,"1234"),
				new Person("�ݻ��",10000,"1234"), new Person("������",20000,"1234") ,
				new Person("��ī��",10000,"1234"), new Person("���̸�",20000,"1234") ,
				new Person("���α�",10000,"1234"), new Person("�̻��ؾ�",20000,"1234") 
		};

		public Person[] getP() {
			return p;
		}
		public void setP(Person[] p) {
			this.p = p;
		}
		public int checkPerson(Person p){ // ����ڰ� �ִ��� Ȯ��
			for(int i=0 ;i<this.p.length ;i++)
			{
				if(this.p[i].getName().equals(p.getName()))
				{
					return i;
				}
			}
			System.out.println("����ڰ� ��ȿ���� �ʽ��ϴ�.");
			return -1;
		}
		public boolean checkPwd(Person p){ // �н����� üũ
			for(int i=0 ;i<this.p.length ;i++)
			{
				if(this.p[i].getPwd().equals(p.getPwd()))
				{
					return true;
				}
			}
			System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
			return false;
		}
		void deposit(Person p ,int money) // �Ա�
		{
			Person p1 = p;
			int IndexOfMan = checkPerson(p);
			if(IndexOfMan == -1)
			{
				return;
			}
			p1.setPwd(inputPwd());
			if(!checkPwd(p1))
			{
				return;
			}
			System.out.println("�Ա��� ���� ó�� ����ϴ�.");
			this.p[IndexOfMan].setMoney(this.p[IndexOfMan].getMoney()+money);
			this.p[IndexOfMan].addLog(p.getName()+" ���� "+money+" ��ŭ �Ա��Ͽ����ϴ�.");
		}
		String inputPwd() // �佺���� �Է�
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("�н����带 �Է��� �ּ���.");
			String str = sc.nextLine();
			return str;
		}
		void withdrawal(Person p ,int money) // �ݾ� ����
		{
			Person p1 = p;
			int IndexOfMan = checkPerson(p);
			if(IndexOfMan == -1)
			{
				return;
			}
			p1.setPwd(inputPwd());
			if(!checkPwd(p1))
			{
				return;
			}
			this.p[IndexOfMan].setMoney(this.p[IndexOfMan].getMoney()-money);
			this.p[IndexOfMan].addLog(this.p[IndexOfMan].getName()+" ���� "+money+" ��ŭ ��� �Ͽ����ϴ�.");
		}
		void showMoney(Person p) // �ܾ���ȸ
		{
			Person p1 = p;
			int IndexOfMan = checkPerson(p);
			if(IndexOfMan == -1)
			{
				return;
			}
			p1.setPwd(inputPwd());
			if(!checkPwd(p1))
			{
				return;
			}
			System.out.println("���� �ܾ��� : "+this.p[IndexOfMan].getMoney());	
		}
		void showLog(Person p) // �α� ���
		{
			Person p1 = p;
			int IndexOfMan = checkPerson(p);
			if(IndexOfMan == -1)
			{
				return;
			}
			p1.setPwd(inputPwd());
			if(!checkPwd(p1))
			{
				return;
			}
			this.p[IndexOfMan].PrintLog();
		}
		void transfer(Person p1, String name, int money)
		{
			int IndexOfManTo = checkPerson(p1);
			int IndexOfManFrom = 0;
			for(int i=0 ;i<p.length ;i++)
			{
				if(p[i].getName().equals(name))
				{
					IndexOfManFrom = i;
					break;
				}
				if(i == p.length-1)
				{
					System.out.println("�߸��� �̸� ��ȸ");
					return;
				}
			}

			p[IndexOfManTo].setMoney(p[IndexOfManTo].getMoney()-money);
			p[IndexOfManFrom].setMoney(p[IndexOfManFrom].getMoney()+money);

			p[IndexOfManTo].addLog(p[IndexOfManTo].getName() + " �� �� " +p[IndexOfManFrom].getName() + "����" +money +"��ŭ ��ü");
			p[IndexOfManFrom].addLog(p[IndexOfManTo].getName() + " �� �� " +p[IndexOfManFrom].getName() + "����" +money +"��ŭ ��ü");
		}
		public Bank() {
			super();

			// TODO Auto-generated constructor stub
		}


		static class Person // ����� Ŭ����
		{

			private String name =""; // ����� �̸�
			private int money = 0;   // �ݾ�
			private log content = new log(); // �α� ����
			private String pwd = ""; // �н�����

			public String getPwd() {
				return pwd;
			}
			public void setPwd(String pwd) {
				this.pwd = pwd;
			}
			public void addLog(String str)
			{
				content.save(str);
			}
			public void PrintLog()
			{
				content.printLog();
			}

			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getMoney() {
				return money;
			}
			public void setMoney(int money) {
				if(money < 0)
				{
					System.out.println("�ܾ��� �����մϴ�.");
					System.out.println("���� �ܾ��� "+this.getMoney());
					System.exit(0);
				}
				this.money = money;
			}
			public log getContent() {
				return content;
			}
			public void setContent(log content) {
				this.content = content;
			}
			public Person(String name, int money, String pwd) {
				super();
				this.name = name;
				this.money = money;
				this.pwd = pwd;
			}
			public Person(String name, int money) {
				super();
				this.name = name;
				this.money = money;
			}

			public Person() {
				super();
				// TODO Auto-generated constructor stub
			}


			static class log
			{
				LinkedList<String> q = new LinkedList<String>(); // ����� �Է���  ������ ������ ť (QUEUE)
				final int Max_Size = 5; // Queue�� �ִ� 5�� ������ ����.

				public void save(String str)
				{
					q.add(str);
					if(q.size() > Max_Size) // �ִ� ������ ������
					{
						q.remove(); // ���� ������ ���� �����Ѵ�.
					}
				}
				public void printLog() // �α׿� ����� ������ ��� ���
				{
					for(String str : q)
					{
						System.out.println(str);
					}
				}

			}

		}

	}


}//end of class
