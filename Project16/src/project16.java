import java.util.Scanner;


public class project16 {
   public static void main(String[] args) {
      Travel a = new Travel();
      a.travelType();// ���� �ɼ� ���� 
      a.printCustomer();// ������� ������ ���
      a.print();// ���ÿ� ���� ���� ����� ���
   }
}
class region
{
   String name;  // ���� �̸�
   String [] travelType; // ����, ����, ����Ʈ
   String [] purpose; // ȿ��, �Թ�, ����
   String [] stay; // ȣ��, ��� , �Խ�Ʈ�Ͽ콺  
   String [] transprot; // ���߱���, ����
   String weather; // ���� , �� , �� - 
   int distance; // �Ÿ� (�ִ��� ����� ��������) ex) �λ� 400km
   int sumOfBudget; // �ϴ� = 0 ���� �ʱ�ȭ
   public region(String name, String[] travelType, String[] purpose, String[] stay, String[] transprot, String weather,
         int distance, int sumOfBudget) {// �������� �����͸� �����ϱ� ���� class
      this.name = name;
      this.travelType = travelType;
      this.purpose = purpose;
      this.stay = stay;
      this.transprot = transprot;
      this.weather = weather;
      this.distance = distance;
      this.sumOfBudget = sumOfBudget;
   }
   public region(){
      super();
   }
}
class Customer// ������� �Է��� �޾� �����͸� �����ϴ� class
{
   private String travelType; // ����Ÿ��
   private String purpose; // ���� ����
   private String numOfPeople; // �ο���
   private String money; // ���� ���
   private String stay; // ���� �ü�
   private String transport; // ���� ����
   public String getTravelType() {
      return travelType;
   }
   public void setTravelType(String travelType) {
      this.travelType = travelType;
   }
   public String getPurpose() {
      return purpose;
   }
   public void setPurpose(String purpose) {
      this.purpose = purpose;
   }
   public String getNumOfPeople() {
      return numOfPeople;
   }
   public void setNumOfPeople(String numOfPeople) {
      this.numOfPeople = numOfPeople;
   }
   public String getMoney() {
      return money;
   }
   public void setMoney(String money) {
      this.money = money;
   }
   public String getStay() {
      return stay;
   }
   public void setStay(String stay) {
      this.stay = stay;
   }
   public String getTransport() {
      return transport;
   }
   public void setTransport(String transport) {
      this.transport = transport;
   }

}
class Travel
{
   Customer cus = new Customer(); // ����� ��ü ȣ��
   region[] reg = {// ����, ����Ÿ��, �������, ���ڽü�, �������, ����, �Ÿ�(km), �ҿ���(ó���� 0���� �ʱ�ȭ)
       new region("����", new String[] { "����", "����Ʈ" }, new String[] { "����" },
            new String[] { "ȣ��", "���" }, new String[] { "���߱���","����" }, "����", 53, 0),
         new region("����", new String[] { "����", "����", "����Ʈ" }, new String[] { "ȿ��", "�Թ�" },
               new String[] { "�Խ�Ʈ�Ͽ콺", "���" }, new String[] { "���߱���", "����" }, "����", 347, 0),
         new region("����", new String[] { "����", "����", "����Ʈ" }, new String[] { "ȿ��", "�Թ�" },
               new String[] { "ȣ��", "���","�Խ�Ʈ�Ͽ콺" }, new String[] { "����" }, "�帲", 359, 0),
         new region("����", new String[] { "����Ʈ", "����" }, new String[] { "�Թ�" },
               new String[] { "�Խ�Ʈ�Ͽ콺", "���" }, new String[] { "���߱���", "����" }, "����", 350, 0),
         new region("��õ", new String[] { "����Ʈ", "����" }, new String[] { "����" },
               new String[] { "�Խ�Ʈ�Ͽ콺", "���" }, new String[] { "���߱���", "����" }, "����", 140, 0),
         new region("����", new String[] { "����", "����" }, new String[] { "ȿ��" },
               new String[] { "�Խ�Ʈ�Ͽ콺", "���" }, new String[] { "���߱���", "����" }, "����", 45, 0),
         new region("�뿵",new String[]{"����Ʈ","����"},new String[]{"����","�Թ�"},
               new String[]{"ȣ��","�Խ�Ʈ�Ͽ콺"},new String[]{"���߱���","����"},"����",377,0), 
         new region("����",new String[]{"����Ʈ","����","����"},new String[]{"ȿ��","�Թ�"},
               new String[]{"ȣ��","���"},new String[]{"���߱���","����"},"�帲",353,0),
         new region("�λ�",new String[]{"����Ʈ","����"},new String[]{"�Թ�"},
               new String[]{"ȣ��","�Խ�Ʈ�Ͽ콺"},new String[]{"���߱���","����"},"�帲",394,0),
         new region("����",new String[]{"����","����","����Ʈ"},new String[]{"ȿ��","�Թ�"},
               new String[]{"ȣ��","���","�Խ�Ʈ�Ͽ콺"},new String[]{"���߱���","����"},"����",195,0),
         new region("��õ",new String[]{"����","����Ʈ"},new String[]{"ȿ��","�Թ�"},
               new String[]{"ȣ��","�Խ�Ʈ�Ͽ콺"},new String[]{"����"},"�ٶ�����",40,0),
         new region("��õ",new String[]{"����","����Ʈ"},new String[]{"�Թ�"},
               new String[]{"���","�Խ�Ʈ�Ͽ콺"},new String[]{"���߱���","����"},"�帲",77,0),
         new region("����",new String[]{"����","����"},new String[]{"����","�Թ�"},
               new String[]{"�Խ�Ʈ�Ͽ콺","���"},new String[]{"���߱���", "����"},"����",95,0) ,
         new region("Ⱦ��",new String[]{"����","����"},new String[]{"����","�Թ�"},
               new String[]{"ȣ��","���"},new String[]{"����"},"�帲",130,0),
         new region("����",new String[]{"����","����", "����Ʈ"},new String[]{"ȿ��","�Թ�"},
               new String[]{"�Խ�Ʈ�Ͽ콺","���"},new String[]{"���߱���"},"����",360,0)

   };
   region[] selectedReg = new region[15]; // ���� ������ �������� �����ϱ� ���� ��ü
   int count[] = new int[15];

   public Travel(Customer cus) {
      this.cus = cus;
   }
   public Travel() {

   }

   public void travelType() { // ����Ÿ�� ���� �� ����ϴ� �޼���
      Scanner sc = new Scanner(System.in);
      while (true) {
         System.out.println("==========step1======================================");
         System.out.println("<����Ÿ��> ����|����|����Ʈ       ");
         System.out.println("=====================================================");
         System.out.print("����Ÿ��>>");
         String input = sc.nextLine();
         if (input.equals("����") || input.equals("����") || input.equals("����Ʈ")) {
            cus.setTravelType(input);
            cus.getTravelType();
            this.purpose();
            break;
         } else {
            System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���!");
         }
      }

   }

   public void purpose() { // ������� ���� �� ����ϴ� �޼���
      Scanner sc = new Scanner(System.in);

      while (true) {
         System.out.println("==========step2====================================");
         System.out.println("<�������> ȿ��|�Թ�|����       ");
         System.out.println("===================================================");
         System.out.print("�������>>");
         String input = sc.nextLine();
         if (input.equals("ȿ��") || input.equals("�Թ�") || input.equals("����")) {
            cus.setPurpose(input);
            setnumOfpeople();
            break;
         } else {
            System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���!");
         }
      }

   }
   public void setnumOfpeople(){ // �ο��� �Է� �� ����ϴ� �޼���
      Scanner sc = new Scanner(System.in);
      System.out.println("==========step3======================================");
      System.out.println("<�ο���> �ο����� ����Դϱ�?  ");
      System.out.println("=====================================================");
      System.out.print("�ο���>>");
      String str = sc.nextLine();
      cus.setNumOfPeople(str);
      this.budget();

   }

   public void budget() { // ���� ���� �Է� �� ����ϴ� �޼���
      Scanner sc = new Scanner(System.in);
      System.out.println("============step4===================================");
      System.out.println("<����> ���� ���⿹��        ");
      System.out.println("====================================================");
      System.out.print("����>>");
      String input = sc.nextLine();
      cus.setMoney(input);
      stay();

   }

   void stay() { // ���ڽü� ����  �� ����ϴ� �޼���
      Scanner sc = new Scanner(System.in);
      while (true) {
         System.out.println("=============step5===============================");
         System.out.println("<���ڽü�> ȣ��|�Խ�Ʈ�Ͽ콺|���       ");
         System.out.println("=================================================");
         System.out.print("���ڽü�>>");
         String str = sc.nextLine();
         if (str.equals("ȣ��") || str.equals("�Խ�Ʈ�Ͽ콺") || str.equals("���")) {
            this.cus.setStay(str);
            break;
         } else {
            System.out.println("�ٽ��Է��ϼ���");
         }

      }
      getTransportInfo();
   }

   void getTransportInfo() { // ���߱��� ���� �� ����ϴ� �޼���
      Scanner sc = new Scanner(System.in);
      while(true){
         System.out.println("=============step6===============================");
         System.out.println("<�������> ���߱���|����       ");
         System.out.println("=================================================");
         System.out.print("�������>>");
         String str = sc.nextLine();
         if(str.equals("���߱���") || str.equals("����"))
         {
            cus.setTransport(str);
            break;
         }
         System.out.println("�߸��� �Է� �Դϴ�.");
      }   
   }
   void printCustomer() {// Customer�� ������ ����ϴ� �޼���
      System.out.println("�¢¢¢¢¢¢¢¢�<������>�¢¢¢¢¢¢¢�");
      System.out.println(" 1.   ���� Ÿ��: "+ cus.getTravelType() + "\t\t\t");
      System.out.println(" 2.   ���� ����: "+ cus.getPurpose() + "\t\t\t" );
      System.out.println(" 3.   ���� �ο�: "+ cus.getNumOfPeople()+ "��" + "\t\t\t");
      System.out.println(" 4.   ���� ����: "+ cus.getMoney() +"��" + "\t\t\t");
      System.out.println(" 5.   ���� ���: "+ cus.getStay() + "\t\t\t");
      System.out.println(" 6.   ���� ����: "+ cus.getTransport()+ "\t\t\t");
      System.out.println("�¢¢¢¢¢¢¢¢¢¢¢¢¢¢¢¢¢¢¢¢¢�");
   }

   int expenseCal(region reg) { // �� �ҿ� ���(1��)�� ����ϱ� ���� �޼���

      int total = 0; // �� �ҿ� ���
      int km = 130;// ������� km �� 130��
      int hotel = 200000; // ȣ�ں��
      int pension = 100000;// ��Ǻ��
      int gest = 50000;// �Խ�Ʈ�Ͽ콺 ���

      if ("���߱���".equals(cus.getTransport())) {// ���߱����� ��� �Ÿ��� ���� 
         if (reg.distance < 100) { // 100km �� ���
            total += 8000;
         } else if (reg.distance < 200) {// 100km ~ 200km�̸� �� ���
            total += 20000;
         } else if (reg.distance < 300) {// 200km ~ 300km�̸� �� ���
            total += 30000;
         } else if (reg.distance >= 300) {// 300km �̻� �� ���
            total += 44000;
         } else{
            System.out.println("�߸��Է��ϼ̽��ϴ�.");
         }
      } else if ("����".equals(cus.getTransport())) { // ������ ���, km�� 130��
         total = reg.distance * km;
      }

      if ("ȣ��".equals(cus.getStay())) {
         total += hotel;
      } else if ("���".equals(cus.getStay())) {
         total += pension;
      } else if ("�Խ�Ʈ�Ͽ콺".equals(cus.getStay())) {
         total += gest;
      }

      return total;
   }// end of expenseCal()
   void selectTravel() {// ������� ���ÿ� ���� ������ �������� �����ϴ� �޼���

      int count[] = new int[15]; // reg ������ ũ��� ���� ũ���� int�� �迭�� �����Ѵ�.

      for (int i = 0; i < reg.length; i++) { // reg �迭�� ũ�⸸ŭ for���� �ݺ��Ѵ�.
         for (int j = 0; j < reg[i].travelType.length; j++) {
            if (reg[i].travelType[j].equals(cus.getTravelType())) { // ���� ����ڰ� �Է��� type�� ������ type�� ���ٸ� cnt�迭�� �ش� index ���� 1��ŭ �����Ѵ�. 
               count[i] += 1;
            }
         }
         for (int j = 0; j < reg[i].purpose.length; j++) { // ���� ����
            if (reg[i].purpose[j].equals(cus.getPurpose())) {
               count[i] += 1;
            }
         }
         for (int j = 0; j < reg[i].stay.length; j++) {// 
            if (reg[i].stay[j].equals(cus.getStay())) {
               count[i] += 1;
            }
         }
         for (int j = 0; j < reg[i].transprot.length; j++) { //
            if (reg[i].transprot[j].equals(cus.getTransport())) {
               count[i] += 1;
            }
         }
      }

      int max = 0;
      for (int i = 0; i < count.length; i++) { // ���� ���� ������ ������ ���� max�� �����Ѵ�.
         if(max<count[i]){ 
            max = count[i];
         }
      }

      int cnt = 0;
      for (int i = 0; i < count.length; i++) {
         if(count[i]==max){
            this.selectedReg[cnt] = reg[i]; // selectedReg �迭�� ���õ� ������ ���� �ִ´�. 
            cnt++; 
         }
      }

   }// end of selectTravel  
   void print() {//������� ���ÿ� ���� ���� ����� ����ϴ� �޼��� 
      selectTravel();
      for (int i = 0; i < selectedReg.length; i++) {
         if(selectedReg[i] == null) { //��ü�� null�̶��
            break;
         } else {
           System.out.println("========================================================="); 
            System.out.println("�� ��õ���� : " + selectedReg[i].name + "\n" + "�� �̵��Ÿ� : " + selectedReg[i].distance + "Km" 
                  +"\n"+"�� ���糯�� : " + selectedReg[i].weather);
            System.out.println("�� "+this.cus.getNumOfPeople()+"���� �ʿ� ���� ��� : "+
                  Integer.parseInt(this.cus.getNumOfPeople()) * this.expenseCal(selectedReg[i])+"��");
            int getMoney = Integer.parseInt(this.cus.getMoney()); //����ڰ� �Է��� ���� ���
            int expCal = Integer.parseInt(this.cus.getNumOfPeople()) * this.expenseCal(selectedReg[i]);//selectTravel() �޼��带 ���� ���� ���� ���
            if ( getMoney - expCal > 0  ) {// �Է��� ��� ���� ���� ��񺸴� ũ�ٸ�
               System.out.println("�� ���� ��� " + (getMoney - expCal) + "��ŭ �����ϴ�.");
            } else {// �Է��� ��� ���� ���� ��񺸴� �۴ٸ�
               System.out.println("�� ���� ��� " + -(getMoney - expCal) + "��ŭ �����մϴ�.");
            }
            System.out.println("=========================================================");
         }
         System.out.println("");

      }
   }

}