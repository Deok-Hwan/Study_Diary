import java.util.LinkedList;
import java.util.Scanner;
/**
 * 
 * @박덕환 은행시스템 
 *  * 입금 , 출금, 계좌이체, 거래내역 조회, 현재 잔액 조회의 기능을 사용할 수 있다.
 *
 */
public class BankTest {
	public static void main(String[] args) {
		Bank KookminBank = new Bank();
		Bank.Person p1 = new BankTest.Bank.Person("박덕환",0);
		
		while(true)
		{
			Scanner sc = new Scanner(System.in);

			System.out.println("--------------------------------------------------------------");
			System.out.println("*                   국민은행에 와주셔서 감사합니다.                    *");
			System.out.println("--------------------------------------------------------------");
			System.out.println("1. 입금 , 2. 출금, 3. 계좌이체 , 4. 거래내역 조회, 5. 현재 잔액 조회, 6. 종료");
			int select = sc.nextInt();
			sc.nextLine();

			if(select == 1 ) // 원하는 기능으로 분기
			{
				System.out.println("입금할 금액을 넣어주세요.");
				KookminBank.deposit(p1, sc.nextInt());
			}else if(select == 2)
			{
				System.out.println("얼마를 출금하겠습니까?");
				KookminBank.withdrawal(p1, sc.nextInt());
			}else if(select == 3)
			{
				System.out.println("계좌 이체를 진행 하겠습니다.");
				System.out.println("계좌 이체를 누구에게 진행하겠습니까?");
				String str = sc.nextLine();
				System.out.println("얼마 입금하시겠습니까?");
				int money = sc.nextInt();
				KookminBank.transfer(p1, str, money);
			}
			else if(select ==4)
			{
				System.out.println("거래 내역을 조회합니다.");
				KookminBank.showLog(p1);
			}
			else if(select == 5)
			{
				KookminBank.showMoney(p1);
			}
			else
			{
				System.out.println("감사합니다. 또 이용해 주세요.");
				break;
			}

		}

	}//end of main


	static class Bank
	{
		private Person p [] = { // 사용자가 은행에 저장되어 있음
				new Person("조보람",20000,"1234"), new Person("박덕환",10000,"1234"),
				new Person("반상수",10000,"1234"), new Person("김찬현",20000,"1234") ,
				new Person("피카츄",10000,"1234"), new Person("파이리",20000,"1234") ,
				new Person("꼬부기",10000,"1234"), new Person("이상해씨",20000,"1234") 
		};

		public Person[] getP() {
			return p;
		}
		public void setP(Person[] p) {
			this.p = p;
		}
		public int checkPerson(Person p){ // 사용자가 있는지 확인
			for(int i=0 ;i<this.p.length ;i++)
			{
				if(this.p[i].getName().equals(p.getName()))
				{
					return i;
				}
			}
			System.out.println("사용자가 유효하지 않습니다.");
			return -1;
		}
		public boolean checkPwd(Person p){ // 패스워드 체크
			for(int i=0 ;i<this.p.length ;i++)
			{
				if(this.p[i].getPwd().equals(p.getPwd()))
				{
					return true;
				}
			}
			System.out.println("비밀번호가 맞지 않습니다.");
			return false;
		}
		void deposit(Person p ,int money) // 입금
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
			System.out.println("입금이 정상 처리 됬습니다.");
			this.p[IndexOfMan].setMoney(this.p[IndexOfMan].getMoney()+money);
			this.p[IndexOfMan].addLog(p.getName()+" 님이 "+money+" 만큼 입금하였습니다.");
		}
		String inputPwd() // 페스워드 입력
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("패스워드를 입력해 주세요.");
			String str = sc.nextLine();
			return str;
		}
		void withdrawal(Person p ,int money) // 금액 인출
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
			this.p[IndexOfMan].addLog(this.p[IndexOfMan].getName()+" 님이 "+money+" 만큼 출금 하였습니다.");
		}
		void showMoney(Person p) // 잔액조회
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
			System.out.println("현재 잔액은 : "+this.p[IndexOfMan].getMoney());	
		}
		void showLog(Person p) // 로그 출력
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
					System.out.println("잘못된 이름 조회");
					return;
				}
			}

			p[IndexOfManTo].setMoney(p[IndexOfManTo].getMoney()-money);
			p[IndexOfManFrom].setMoney(p[IndexOfManFrom].getMoney()+money);

			p[IndexOfManTo].addLog(p[IndexOfManTo].getName() + " 님 이 " +p[IndexOfManFrom].getName() + "에게" +money +"만큼 이체");
			p[IndexOfManFrom].addLog(p[IndexOfManTo].getName() + " 님 이 " +p[IndexOfManFrom].getName() + "에게" +money +"만큼 이체");
		}
		public Bank() {
			super();

			// TODO Auto-generated constructor stub
		}


		static class Person // 사용자 클래스
		{

			private String name =""; // 사용자 이름
			private int money = 0;   // 금액
			private log content = new log(); // 로그 포함
			private String pwd = ""; // 패스워드

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
					System.out.println("잔액이 부족합니다.");
					System.out.println("현재 잔액은 "+this.getMoney());
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
				LinkedList<String> q = new LinkedList<String>(); // 사용자 입력한  내용을 저장할 큐 (QUEUE)
				final int Max_Size = 5; // Queue에 최대 5개 까지만 저장.

				public void save(String str)
				{
					q.add(str);
					if(q.size() > Max_Size) // 최대 갯수를 넘으면
					{
						q.remove(); // 가장 오래된 값을 제거한다.
					}
				}
				public void printLog() // 로그에 저장된 내용을 모두 출력
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
