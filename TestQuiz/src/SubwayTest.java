import java.util.Scanner;

public class SubwayTest {
	public static void main(String[] args) {
		Subway sub = new Subway();
		Customer cus1 = new Customer();
		cus1.stepInSubway(sub);

	}// end of main

	
}// end of class

class Subway {

	String size[] = { "15cm", "30cm" };
	int menuPrice[] = { 5200, 8000 };
	String menu[] = { "치킨데리야끼", "써브웨이클럽", "스테이크치즈", "스파이시이탈리안" };
	String step2[] = { "하티", "위트", "허니오트", "화이트", "파마산오레가노", "플랫브레드" };
	String step3[] = { "베이컨", "더블미트", "더블치즈", "계란", "아보카도" };
	int step3Price15[] = { 900, 1500, 700, 800, 1100 };
	String step4[] = { "양상추", "토마토", "오이", "피망", "양파", "피클", "올리브", "할라피뇨" };
	String step5[] = { "새콤한 맛", "달콤한 맛", "고소한 맛", "매콤한 맛", "기타" };
	String step6Drink[] = { "콜라", "사이다", "환타" };
	String step6Side[] = { "쿠키", "칩" };


	int choice;
	int choiceNumber;

	String customerInput = "";

	Product product;

	void input() {  
		Scanner sc = new Scanner(System.in);
		System.out.print("번호입력>>");
		customerInput = sc.nextLine();
		customerInput = customerInput.trim();
	}

	void start() {
		product = new Product();

		step1();
	}

	void step1() {

		System.out.println("====STEP1> MENU=============="); // 메뉴판 출력
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + 1 + ". " + menu[i]);
		}
		System.out.println("=============================");

		exit: while (true) { // 잘못된 입력값이 들어올 경우 무한 반복
			input();
			if (isNumber(customerInput)) { // 고객의 입력값이 숫자일 경우 
				choiceNumber = Integer.parseInt(customerInput);
				if (choiceNumber > 0 && menu.length >= choiceNumber) { // 고객의 입력값이 0보다 크고 메뉴 배열의 크기보다는 작다면 분기
					product.menu = menu[choiceNumber - 1]; // product 객체의  첫번째 메뉴에 새로운 값 입력.
					break exit; 
				} 

			} else { // 고객의 입력값이 숫자가 아닐 경우.
				for (int i = 0; i < menu.length; i++) {
					if (customerInput.equals(menu[i])) {
						product.menu = menu[i];
						break exit;

					}
				}
			}//endofWhile
			System.out.println("잘못된 입력입니다.");
		}
		printMenu(); // 고객 입력값을 갱신후 프린트.
		size(); // 2단계 함수 호출.
	}

	void size() {
		System.out.println("====STEP2> size=============="); // 메뉴판 출력
		for (int i = 0; i < size.length; i++) {
			System.out.println(i + 1 + ". " + size[i] + "\t\t" + menuPrice[i]);
		}
		System.out.println("=============================");
		exit: while (true) {
			input();
			if (isNumber(customerInput)) { //고객 입력값이 숫자라면
				choiceNumber = Integer.parseInt(customerInput);
				if (choiceNumber == 1) {
					product.size = true;
					System.out.println("15cm를 선택하셨습니다.");
					break exit;
				} else if (choiceNumber == 2) {
					product.size = false;
					System.out.println("30cm를 선택하셨습니다.");
					break exit;
				}
			} else { // 고객 입력값이 문자라면
				if (customerInput.equals("15") || customerInput.equals("15cm")) {
					product.size = true; // product객체의 size가 1이면 15cm.
					System.out.println("15cm를 선택하셨습니다.");
					break exit;

				} else if (customerInput.equals("30") || customerInput.equals("30cm")) {
					product.size = false;// product객체의 size가 0이면 30cm.
					System.out.println("30cm를 선택하셨습니다.");
					break exit;
				}
			}
			System.out.println("잘못된 입력입니다.");
		}
		product.price += product.size ? menuPrice[0] : menuPrice[1]; // product의 값을 갱신.
		printMenu();
		step2();

	}

	void step2() {
		Scanner sc = new Scanner(System.in);

		System.out.println("====STEP2> BRAED=============="); //메뉴판 출력
		for (int i = 0; i < step2.length; i++) {
			System.out.println(i + 1 + ". " + step2[i]);
		}
		System.out.println("=============================");
		exit: while (true) { // 입력값이 잘못될 경우 무한반복
			input();
			if (isNumber(customerInput)) { // 입력값이 숫자일 경우
				choiceNumber = Integer.parseInt(customerInput);
				if (choiceNumber > 0 && step2.length >= choiceNumber) {
					product.step2 = step2[choiceNumber - 1];
					break exit;
				} 
			} else { // 문자일 경우
				for (int i = 0; i < step2.length; i++) {
					if (customerInput.equals(step2[i])) {
						product.step2 = step2[i];
						break exit;

					}
				}
			}
			System.out.println("잘못된 입력입니다.");
			sc.close();
		}
		printMenu();
		step3();
	}

	void step3() {
		Scanner sc = new Scanner(System.in);

		System.out.println("====STEP3> EXTRAS============"); // 메뉴판 출력
		for (int i = 0; i < step3.length; i++) {
			System.out.println(i + 1 + ". " + step3[i] + " " + step3Price15[i] + "\t|" + (step3Price15[i] * 2));

		}
		System.out.println("=============================");
		String str ="";
		int i=0;
		while (true) { // 잘못된 입력값일 경우 무한반복
			exit:for ( ; i < step3.length; ) { // 고를수 있는 최대 메뉴의 크기까지 반복
				input();
				if (isNumber(customerInput)) { // 정수라면
					choiceNumber = Integer.parseInt(customerInput);
					if (choiceNumber > 0 && step3.length >= choiceNumber) {
						product.step3[i] = step3[choiceNumber - 1]; // 메뉴값을  프로덕트 객체의 step3배열에 저장
						if(product.size){ // 사이즈가 15cm를 선택 했다면
							this.updatePrice(step3Price15[choiceNumber-1]);
						}
						else
						{ //사이즈가 30cm를 선택 했다면
							this.updatePrice(step3Price15[choiceNumber-1] * 2); // 30cm 일 경우 추가 비용이 2배
						}
						break exit;
					} 
				} else { // 문자열 이라면 
					for (int j = 0; j < step3.length; j++) {
						if (customerInput.equals(step3[j])) {
							product.step3[i] = step3[j]; // 메뉴값 저장
							if(product.size){
								this.updatePrice(step3Price15[choiceNumber-1]);
							}
							else
							{
								this.updatePrice(step3Price15[choiceNumber-1]*2);
							}
							break exit;
						}
					}
				}

				System.out.println("잘못된 입력값입니다.");
			}
		System.out.println("더 선택 하시겠습니까?(y/n)");
		str = sc.nextLine();
		if(str.equals("n"))
		{
			break ;
		}
		i++;
		}

		printMenu();

		step4();
	}

	void step4() {
		Scanner sc = new Scanner(System.in);

		System.out.println("====STEP4> VEGGIES==========="); //메뉴판 출력
		for (int i = 0; i < step4.length; i++) {
			System.out.println(i + 1 + ". " + step4[i]);
		}
		System.out.println("=============================");

		int i = 0; 
		String str =""; // 추가 유무를 저장할 변수.
		while (true) {
			exit :	for ( ; i < step4.length; ) {
				input();
				if (isNumber(customerInput)) {
					choiceNumber = Integer.parseInt(customerInput);
					if (choiceNumber > 0 && step4.length >= choiceNumber) {
						product.step4[i] = step4[choiceNumber - 1];
						break exit;
					}
				} else {
					for (int j = 0; j < step4.length; j++) {
						if (customerInput.equals(step4[j])) {
							product.step4[i] = step4[j];
							break exit;
						}
					}
				}
				System.out.println("잘못된 입력값 입니다.");
			}
		System.out.println("더 선택 하시겠습니까?(y/n)");
		str = sc.nextLine();
		if(str.equals("n"))
		{
			break;
		}	

		i++;
		}
		printMenu();
		step5();
	}

	void step5() {
		Scanner sc = new Scanner(System.in);

		System.out.println("====STEP5> SAUCE============="); // 메뉴판 출력
		for (int i = 0; i < step5.length; i++) {
			System.out.println(i + 1 + ". " + step5[i]);
		}
		System.out.println("=============================");

		String str = "";
		int i = 0;

		while (true) {
			exit : for(  ; i < step5.length; ) {
				input();
				if (isNumber(customerInput)) {
					choiceNumber = Integer.parseInt(customerInput);
					if (choiceNumber > 0 && step5.length >= choiceNumber) {
						product.step5[i] = step5[choiceNumber - 1];
						break exit;
					} 
				} else {
					for (int j = 0; j < step5.length; j++) {
						if (customerInput.equals(step5[j])) {
							product.step5[i] = step5[j];
							break exit;
						}
					}
				}
				System.out.println("잘못된 입력값 입니다.");
			}
		System.out.println("더 선택 하시겠습니까?(y/n)");
		str = sc.nextLine();
		if(str.equals("n"))
		{
			break;
		}
		i++;
		}

		System.out.println("세트메뉴 추가하실건가요? Y/N");
		str = sc.nextLine(); 
		str.toLowerCase(); // 입력받은 알파벳을 소문자로 변환
		if (str.equals("y")) {
			product.price += 1900;
			printMenu();
			step6Drink();
		} else if (customerInput.equals("n") || customerInput.equals("N")) {
			System.out.println("선택 완료하였습니다.");
			printMenu();

		}

	}

	void step6Drink() {
		Scanner sc = new Scanner(System.in);

		System.out.println("====STEP6> Drink=============");
		for (int i = 0; i < step6Drink.length; i++) {
			System.out.println(i + 1 + ". " + step6Drink[i]);
		}
		System.out.println("=============================");
		exit: while (true) {
			input();
			if (isNumber(customerInput)) {
				choiceNumber = Integer.parseInt(customerInput);
				if (choiceNumber > 0 && step6Drink.length >= choiceNumber) {
					product.step6Drink = step6Drink[choiceNumber - 1];
					break exit;
				} 
			} else {
				for (int i = 0; i < step6Drink.length; i++) {
					if (customerInput.equals(step6Drink[i])) {
						product.step6Drink = step6Drink[i];
						break exit;

					}
				}
			}
			System.out.println("잘못된 입력입니다.");
		}
		printMenu();
		step6Side(); 
	}

	void step6Side() {
		Scanner sc = new Scanner(System.in);

		System.out.println("====STEP6> Side=============");
		for (int i = 0; i < step6Side.length; i++) {
			System.out.println(i + 1 + ". " + step6Side[i]);
		}
		System.out.println("=============================");
		exit: while (true) {
			input();
			if (isNumber(customerInput)) {
				choiceNumber = Integer.parseInt(customerInput);
				if (choiceNumber > 0 && step6Side.length >= choiceNumber) {
					product.step6Side = step6Side[choiceNumber - 1];
					break exit;
				}
			} else {
				for (int i = 0; i < step6Side.length; i++) {
					if (customerInput.equals(step6Side[i])) {
						product.step6Side = step6Side[i];
						break exit;

					}
				}
			}
			System.out.println("잘못된 입력입니다.");
		}

		printMenu();
	}

	void printMenu() { // 메뉴를 출력하는 메소드
		System.out.println();
		System.out.println("선택메뉴>>");

		System.out.println("Menu >" + product.menu);
		System.out.println("size >" + (product.size ? "15cm" : "30cm"));
		System.out.println("step2 >" + product.step2);
		System.out.print("step3 >");
		for (int i = 0; i < step3.length; i++) {
			if (!(product.step3[i].equals(""))) {

				System.out.print(product.step3[i] + " ");
			} 
		}
		System.out.println();

		System.out.print("step4 >");
		for (int i = 0; i < step4.length; i++) {
			if (!(product.step4[i].equals(""))) {

				System.out.print(product.step4[i] + " ");
			} 
		}
		System.out.println();

		System.out.print("step5 >");
		for (int i = 0; i < step5.length; i++) {
			if (!(product.step5[i].equals(""))) {

				System.out.print(product.step5[i] + " ");
			}
		}
		System.out.println();

		if (!(product.step6Drink.equals(""))) {
			System.out.println("step6 >" + product.step6Drink + "|" + product.step6Side);
		}
		System.out.println("금액 : " + product.price);
		System.out.println();
	}



	public static boolean isNumber(String customerInput) { // 문자열이 들어왔을 때 숫자로 구성되어 있는지 확인하는 메서드
		try {
			Integer.parseInt(customerInput);
			return true;

		} catch (NumberFormatException e) {
			return false;
		}
	}
	public void updatePrice(int price)
	{
		this.product.price += price;
	}
}

class Customer { 
	int money;
	Product product;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public void stepInSubway(Subway s) //고객이 서브웨이에 들어감
	{
		s.start();
		product = s.product;
	}

}

class Product {
	String menu = "";
	boolean size;
	String step2 = "";
	String step3[];
	String step4[];
	String step5[];
	String step6Drink = "";
	String step6Side = "";
	int price;

	public Product() { // 생성자에서 배열 객체를 인스턴스화 시킴.
		step3 = new String[5];
		step4 = new String[8];
		step5 = new String[5];

		for (int i = 0; i < step3.length; i++) {
			step3[i] = ""; // 배열값을 ""으로 초기화
		}
		for (int i = 0; i < step4.length; i++) {
			step4[i] = "";
		}
		for (int i = 0; i < step5.length; i++) {
			step5[i] = "";
		}
	}
}
