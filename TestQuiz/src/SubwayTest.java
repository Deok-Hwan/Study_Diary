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
	String menu[] = { "ġŲ�����߳�", "������Ŭ��", "������ũġ��", "�����̽���Ż����" };
	String step2[] = { "��Ƽ", "��Ʈ", "��Ͽ�Ʈ", "ȭ��Ʈ", "�ĸ����������", "�÷��극��" };
	String step3[] = { "������", "�����Ʈ", "����ġ��", "���", "�ƺ�ī��" };
	int step3Price15[] = { 900, 1500, 700, 800, 1100 };
	String step4[] = { "�����", "�丶��", "����", "�Ǹ�", "����", "��Ŭ", "�ø���", "�Ҷ��Ǵ�" };
	String step5[] = { "������ ��", "������ ��", "����� ��", "������ ��", "��Ÿ" };
	String step6Drink[] = { "�ݶ�", "���̴�", "ȯŸ" };
	String step6Side[] = { "��Ű", "Ĩ" };


	int choice;
	int choiceNumber;

	String customerInput = "";

	Product product;

	void input() {  
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȣ�Է�>>");
		customerInput = sc.nextLine();
		customerInput = customerInput.trim();
	}

	void start() {
		product = new Product();

		step1();
	}

	void step1() {

		System.out.println("====STEP1> MENU=============="); // �޴��� ���
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + 1 + ". " + menu[i]);
		}
		System.out.println("=============================");

		exit: while (true) { // �߸��� �Է°��� ���� ��� ���� �ݺ�
			input();
			if (isNumber(customerInput)) { // ���� �Է°��� ������ ��� 
				choiceNumber = Integer.parseInt(customerInput);
				if (choiceNumber > 0 && menu.length >= choiceNumber) { // ���� �Է°��� 0���� ũ�� �޴� �迭�� ũ�⺸�ٴ� �۴ٸ� �б�
					product.menu = menu[choiceNumber - 1]; // product ��ü��  ù��° �޴��� ���ο� �� �Է�.
					break exit; 
				} 

			} else { // ���� �Է°��� ���ڰ� �ƴ� ���.
				for (int i = 0; i < menu.length; i++) {
					if (customerInput.equals(menu[i])) {
						product.menu = menu[i];
						break exit;

					}
				}
			}//endofWhile
			System.out.println("�߸��� �Է��Դϴ�.");
		}
		printMenu(); // �� �Է°��� ������ ����Ʈ.
		size(); // 2�ܰ� �Լ� ȣ��.
	}

	void size() {
		System.out.println("====STEP2> size=============="); // �޴��� ���
		for (int i = 0; i < size.length; i++) {
			System.out.println(i + 1 + ". " + size[i] + "\t\t" + menuPrice[i]);
		}
		System.out.println("=============================");
		exit: while (true) {
			input();
			if (isNumber(customerInput)) { //�� �Է°��� ���ڶ��
				choiceNumber = Integer.parseInt(customerInput);
				if (choiceNumber == 1) {
					product.size = true;
					System.out.println("15cm�� �����ϼ̽��ϴ�.");
					break exit;
				} else if (choiceNumber == 2) {
					product.size = false;
					System.out.println("30cm�� �����ϼ̽��ϴ�.");
					break exit;
				}
			} else { // �� �Է°��� ���ڶ��
				if (customerInput.equals("15") || customerInput.equals("15cm")) {
					product.size = true; // product��ü�� size�� 1�̸� 15cm.
					System.out.println("15cm�� �����ϼ̽��ϴ�.");
					break exit;

				} else if (customerInput.equals("30") || customerInput.equals("30cm")) {
					product.size = false;// product��ü�� size�� 0�̸� 30cm.
					System.out.println("30cm�� �����ϼ̽��ϴ�.");
					break exit;
				}
			}
			System.out.println("�߸��� �Է��Դϴ�.");
		}
		product.price += product.size ? menuPrice[0] : menuPrice[1]; // product�� ���� ����.
		printMenu();
		step2();

	}

	void step2() {
		Scanner sc = new Scanner(System.in);

		System.out.println("====STEP2> BRAED=============="); //�޴��� ���
		for (int i = 0; i < step2.length; i++) {
			System.out.println(i + 1 + ". " + step2[i]);
		}
		System.out.println("=============================");
		exit: while (true) { // �Է°��� �߸��� ��� ���ѹݺ�
			input();
			if (isNumber(customerInput)) { // �Է°��� ������ ���
				choiceNumber = Integer.parseInt(customerInput);
				if (choiceNumber > 0 && step2.length >= choiceNumber) {
					product.step2 = step2[choiceNumber - 1];
					break exit;
				} 
			} else { // ������ ���
				for (int i = 0; i < step2.length; i++) {
					if (customerInput.equals(step2[i])) {
						product.step2 = step2[i];
						break exit;

					}
				}
			}
			System.out.println("�߸��� �Է��Դϴ�.");
			sc.close();
		}
		printMenu();
		step3();
	}

	void step3() {
		Scanner sc = new Scanner(System.in);

		System.out.println("====STEP3> EXTRAS============"); // �޴��� ���
		for (int i = 0; i < step3.length; i++) {
			System.out.println(i + 1 + ". " + step3[i] + " " + step3Price15[i] + "\t|" + (step3Price15[i] * 2));

		}
		System.out.println("=============================");
		String str ="";
		int i=0;
		while (true) { // �߸��� �Է°��� ��� ���ѹݺ�
			exit:for ( ; i < step3.length; ) { // ���� �ִ� �ִ� �޴��� ũ����� �ݺ�
				input();
				if (isNumber(customerInput)) { // �������
					choiceNumber = Integer.parseInt(customerInput);
					if (choiceNumber > 0 && step3.length >= choiceNumber) {
						product.step3[i] = step3[choiceNumber - 1]; // �޴�����  ���δ�Ʈ ��ü�� step3�迭�� ����
						if(product.size){ // ����� 15cm�� ���� �ߴٸ�
							this.updatePrice(step3Price15[choiceNumber-1]);
						}
						else
						{ //����� 30cm�� ���� �ߴٸ�
							this.updatePrice(step3Price15[choiceNumber-1] * 2); // 30cm �� ��� �߰� ����� 2��
						}
						break exit;
					} 
				} else { // ���ڿ� �̶�� 
					for (int j = 0; j < step3.length; j++) {
						if (customerInput.equals(step3[j])) {
							product.step3[i] = step3[j]; // �޴��� ����
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

				System.out.println("�߸��� �Է°��Դϴ�.");
			}
		System.out.println("�� ���� �Ͻðڽ��ϱ�?(y/n)");
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

		System.out.println("====STEP4> VEGGIES==========="); //�޴��� ���
		for (int i = 0; i < step4.length; i++) {
			System.out.println(i + 1 + ". " + step4[i]);
		}
		System.out.println("=============================");

		int i = 0; 
		String str =""; // �߰� ������ ������ ����.
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
				System.out.println("�߸��� �Է°� �Դϴ�.");
			}
		System.out.println("�� ���� �Ͻðڽ��ϱ�?(y/n)");
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

		System.out.println("====STEP5> SAUCE============="); // �޴��� ���
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
				System.out.println("�߸��� �Է°� �Դϴ�.");
			}
		System.out.println("�� ���� �Ͻðڽ��ϱ�?(y/n)");
		str = sc.nextLine();
		if(str.equals("n"))
		{
			break;
		}
		i++;
		}

		System.out.println("��Ʈ�޴� �߰��Ͻǰǰ���? Y/N");
		str = sc.nextLine(); 
		str.toLowerCase(); // �Է¹��� ���ĺ��� �ҹ��ڷ� ��ȯ
		if (str.equals("y")) {
			product.price += 1900;
			printMenu();
			step6Drink();
		} else if (customerInput.equals("n") || customerInput.equals("N")) {
			System.out.println("���� �Ϸ��Ͽ����ϴ�.");
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
			System.out.println("�߸��� �Է��Դϴ�.");
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
			System.out.println("�߸��� �Է��Դϴ�.");
		}

		printMenu();
	}

	void printMenu() { // �޴��� ����ϴ� �޼ҵ�
		System.out.println();
		System.out.println("���ø޴�>>");

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
		System.out.println("�ݾ� : " + product.price);
		System.out.println();
	}



	public static boolean isNumber(String customerInput) { // ���ڿ��� ������ �� ���ڷ� �����Ǿ� �ִ��� Ȯ���ϴ� �޼���
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

	public void stepInSubway(Subway s) //���� ������̿� ��
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

	public Product() { // �����ڿ��� �迭 ��ü�� �ν��Ͻ�ȭ ��Ŵ.
		step3 = new String[5];
		step4 = new String[8];
		step5 = new String[5];

		for (int i = 0; i < step3.length; i++) {
			step3[i] = ""; // �迭���� ""���� �ʱ�ȭ
		}
		for (int i = 0; i < step4.length; i++) {
			step4[i] = "";
		}
		for (int i = 0; i < step5.length; i++) {
			step5[i] = "";
		}
	}
}
