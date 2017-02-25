import java.util.Scanner;


public class project16 {
   public static void main(String[] args) {
      Travel a = new Travel();
      a.travelType();// 여행 옵션 선택 
      a.printCustomer();// 사용자의 정보를 출력
      a.print();// 선택에 따른 최종 결과를 출력
   }
}
class region
{
   String name;  // 지역 이름
   String [] travelType; // 가족, 관광, 데이트
   String [] purpose; // 효도, 먹방, 레져
   String [] stay; // 호텔, 펜션 , 게스트하우스  
   String [] transprot; // 대중교통, 자차
   String weather; // 맑음 , 비 , 눈 - 
   int distance; // 거리 (최대한 사실을 바탕으로) ex) 부산 400km
   int sumOfBudget; // 일단 = 0 으로 초기화
   public region(String name, String[] travelType, String[] purpose, String[] stay, String[] transprot, String weather,
         int distance, int sumOfBudget) {// 지역마다 데이터를 저장하기 위한 class
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
class Customer// 사용자의 입력을 받아 데이터를 저장하는 class
{
   private String travelType; // 여행타입
   private String purpose; // 여행 목적
   private String numOfPeople; // 인원수
   private String money; // 예상 경비
   private String stay; // 숙박 시설
   private String transport; // 교통 수단
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
   Customer cus = new Customer(); // 사용자 객체 호출
   region[] reg = {// 지역, 여행타입, 여행목적, 숙박시설, 교통수단, 날씨, 거리(km), 소요경비(처음은 0으로 초기화)
       new region("용인", new String[] { "가족", "데이트" }, new String[] { "레져" },
            new String[] { "호텔", "펜션" }, new String[] { "대중교통","자차" }, "맑음", 53, 0),
         new region("여수", new String[] { "가족", "관광", "데이트" }, new String[] { "효도", "먹방" },
               new String[] { "게스트하우스", "펜션" }, new String[] { "대중교통", "자차" }, "맑음", 347, 0),
         new region("보성", new String[] { "가족", "관광", "데이트" }, new String[] { "효도", "먹방" },
               new String[] { "호텔", "펜션","게스트하우스" }, new String[] { "자차" }, "흐림", 359, 0),
         new region("목포", new String[] { "데이트", "관광" }, new String[] { "먹방" },
               new String[] { "게스트하우스", "펜션" }, new String[] { "대중교통", "자차" }, "맑음", 350, 0),
         new region("제천", new String[] { "데이트", "관광" }, new String[] { "관광" },
               new String[] { "게스트하우스", "펜션" }, new String[] { "대중교통", "자차" }, "맑음", 140, 0),
         new region("파주", new String[] { "가족", "관광" }, new String[] { "효도" },
               new String[] { "게스트하우스", "펜션" }, new String[] { "대중교통", "자차" }, "맑음", 45, 0),
         new region("통영",new String[]{"데이트","관광"},new String[]{"레져","먹방"},
               new String[]{"호텔","게스트하우스"},new String[]{"대중교통","자차"},"맑음",377,0), 
         new region("경주",new String[]{"데이트","관광","가족"},new String[]{"효도","먹방"},
               new String[]{"호텔","펜션"},new String[]{"대중교통","자차"},"흐림",353,0),
         new region("부산",new String[]{"데이트","관광"},new String[]{"먹방"},
               new String[]{"호텔","게스트하우스"},new String[]{"대중교통","자차"},"흐림",394,0),
         new region("전주",new String[]{"가족","관광","데이트"},new String[]{"효도","먹방"},
               new String[]{"호텔","펜션","게스트하우스"},new String[]{"대중교통","자차"},"맑음",195,0),
         new region("인천",new String[]{"가족","데이트"},new String[]{"효도","먹방"},
               new String[]{"호텔","게스트하우스"},new String[]{"자차"},"바람많음",40,0),
         new region("춘천",new String[]{"가족","데이트"},new String[]{"먹방"},
               new String[]{"펜션","게스트하우스"},new String[]{"대중교통","자차"},"흐림",77,0),
         new region("가평",new String[]{"가족","관광"},new String[]{"레져","먹방"},
               new String[]{"게스트하우스","펜션"},new String[]{"대중교통", "자차"},"맑음",95,0) ,
         new region("횡성",new String[]{"가족","관광"},new String[]{"레져","먹방"},
               new String[]{"호텔","펜션"},new String[]{"자차"},"흐림",130,0),
         new region("포항",new String[]{"가족","관광", "데이트"},new String[]{"효도","먹방"},
               new String[]{"게스트하우스","펜션"},new String[]{"대중교통"},"폭설",360,0)

   };
   region[] selectedReg = new region[15]; // 가장 적합한 여행지를 저장하기 위한 객체
   int count[] = new int[15];

   public Travel(Customer cus) {
      this.cus = cus;
   }
   public Travel() {

   }

   public void travelType() { // 여행타입 선택 및 출력하는 메서드
      Scanner sc = new Scanner(System.in);
      while (true) {
         System.out.println("==========step1======================================");
         System.out.println("<여행타입> 가족|관광|데이트       ");
         System.out.println("=====================================================");
         System.out.print("여행타입>>");
         String input = sc.nextLine();
         if (input.equals("가족") || input.equals("관광") || input.equals("데이트")) {
            cus.setTravelType(input);
            cus.getTravelType();
            this.purpose();
            break;
         } else {
            System.out.println("잘못입력하셨습니다. 다시 입력해주세요!");
         }
      }

   }

   public void purpose() { // 여행목적 선택 및 출력하는 메서드
      Scanner sc = new Scanner(System.in);

      while (true) {
         System.out.println("==========step2====================================");
         System.out.println("<여행목적> 효도|먹방|레져       ");
         System.out.println("===================================================");
         System.out.print("여행목적>>");
         String input = sc.nextLine();
         if (input.equals("효도") || input.equals("먹방") || input.equals("레져")) {
            cus.setPurpose(input);
            setnumOfpeople();
            break;
         } else {
            System.out.println("잘못입력하셨습니다. 다시 입력해주세요!");
         }
      }

   }
   public void setnumOfpeople(){ // 인원수 입력 및 출력하는 메서드
      Scanner sc = new Scanner(System.in);
      System.out.println("==========step3======================================");
      System.out.println("<인원수> 인원수는 몇명입니까?  ");
      System.out.println("=====================================================");
      System.out.print("인원수>>");
      String str = sc.nextLine();
      cus.setNumOfPeople(str);
      this.budget();

   }

   public void budget() { // 예상 지출 입력 및 출력하는 메서드
      Scanner sc = new Scanner(System.in);
      System.out.println("============step4===================================");
      System.out.println("<예산> 예상 지출예산        ");
      System.out.println("====================================================");
      System.out.print("예산>>");
      String input = sc.nextLine();
      cus.setMoney(input);
      stay();

   }

   void stay() { // 숙박시설 선택  및 출력하는 메서드
      Scanner sc = new Scanner(System.in);
      while (true) {
         System.out.println("=============step5===============================");
         System.out.println("<숙박시설> 호텔|게스트하우스|펜션       ");
         System.out.println("=================================================");
         System.out.print("숙박시설>>");
         String str = sc.nextLine();
         if (str.equals("호텔") || str.equals("게스트하우스") || str.equals("펜션")) {
            this.cus.setStay(str);
            break;
         } else {
            System.out.println("다시입력하세요");
         }

      }
      getTransportInfo();
   }

   void getTransportInfo() { // 대중교통 선택 및 출력하는 메서드
      Scanner sc = new Scanner(System.in);
      while(true){
         System.out.println("=============step6===============================");
         System.out.println("<교통수단> 대중교통|자차       ");
         System.out.println("=================================================");
         System.out.print("교통수단>>");
         String str = sc.nextLine();
         if(str.equals("대중교통") || str.equals("자차"))
         {
            cus.setTransport(str);
            break;
         }
         System.out.println("잘못된 입력 입니다.");
      }   
   }
   void printCustomer() {// Customer의 정보를 출력하는 메서드
      System.out.println("◈◈◈◈◈◈◈◈◈<고객정보>◈◈◈◈◈◈◈◈");
      System.out.println(" 1.   여행 타입: "+ cus.getTravelType() + "\t\t\t");
      System.out.println(" 2.   여행 목적: "+ cus.getPurpose() + "\t\t\t" );
      System.out.println(" 3.   여행 인원: "+ cus.getNumOfPeople()+ "명" + "\t\t\t");
      System.out.println(" 4.   여행 예산: "+ cus.getMoney() +"원" + "\t\t\t");
      System.out.println(" 5.   숙박 장소: "+ cus.getStay() + "\t\t\t");
      System.out.println(" 6.   교통 수단: "+ cus.getTransport()+ "\t\t\t");
      System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
   }

   int expenseCal(region reg) { // 총 소요 경비(1인)를 계산하기 위한 메서드

      int total = 0; // 총 소요 경비
      int km = 130;// 자차경우 km 당 130원
      int hotel = 200000; // 호텔비용
      int pension = 100000;// 펜션비용
      int gest = 50000;// 게스트하우스 비용

      if ("대중교통".equals(cus.getTransport())) {// 대중교통일 경우 거리에 따라 
         if (reg.distance < 100) { // 100km 일 경우
            total += 8000;
         } else if (reg.distance < 200) {// 100km ~ 200km미만 일 경우
            total += 20000;
         } else if (reg.distance < 300) {// 200km ~ 300km미만 일 경우
            total += 30000;
         } else if (reg.distance >= 300) {// 300km 이상 일 경우
            total += 44000;
         } else{
            System.out.println("잘못입력하셨습니다.");
         }
      } else if ("자차".equals(cus.getTransport())) { // 자차일 경우, km당 130원
         total = reg.distance * km;
      }

      if ("호텔".equals(cus.getStay())) {
         total += hotel;
      } else if ("펜션".equals(cus.getStay())) {
         total += pension;
      } else if ("게스트하우스".equals(cus.getStay())) {
         total += gest;
      }

      return total;
   }// end of expenseCal()
   void selectTravel() {// 사용자의 선택에 따른 최적의 여행지를 선택하는 메서드

      int count[] = new int[15]; // reg 변수의 크기와 같은 크기의 int형 배열을 선언한다.

      for (int i = 0; i < reg.length; i++) { // reg 배열의 크기만큼 for문을 반복한다.
         for (int j = 0; j < reg[i].travelType.length; j++) {
            if (reg[i].travelType[j].equals(cus.getTravelType())) { // 만약 사용자가 입력한 type과 지역의 type이 같다면 cnt배열의 해당 index 값을 1만큼 증가한다. 
               count[i] += 1;
            }
         }
         for (int j = 0; j < reg[i].purpose.length; j++) { // 위와 동일
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
      for (int i = 0; i < count.length; i++) { // 가장 많이 참조된 지역의 값을 max에 저장한다.
         if(max<count[i]){ 
            max = count[i];
         }
      }

      int cnt = 0;
      for (int i = 0; i < count.length; i++) {
         if(count[i]==max){
            this.selectedReg[cnt] = reg[i]; // selectedReg 배열에 선택된 지역의 값을 넣는다. 
            cnt++; 
         }
      }

   }// end of selectTravel  
   void print() {//사용자의 선택에 따른 최종 결과를 출력하는 메서드 
      selectTravel();
      for (int i = 0; i < selectedReg.length; i++) {
         if(selectedReg[i] == null) { //객체가 null이라면
            break;
         } else {
           System.out.println("========================================================="); 
            System.out.println("◆ 추천지역 : " + selectedReg[i].name + "\n" + "◆ 이동거리 : " + selectedReg[i].distance + "Km" 
                  +"\n"+"◆ 현재날씨 : " + selectedReg[i].weather);
            System.out.println("◆ "+this.cus.getNumOfPeople()+"명의 필요 예상 경비 : "+
                  Integer.parseInt(this.cus.getNumOfPeople()) * this.expenseCal(selectedReg[i])+"원");
            int getMoney = Integer.parseInt(this.cus.getMoney()); //사용자가 입력한 예상 경비
            int expCal = Integer.parseInt(this.cus.getNumOfPeople()) * this.expenseCal(selectedReg[i]);//selectTravel() 메서드를 통해 계산된 최종 경비
            if ( getMoney - expCal > 0  ) {// 입력한 경비가 최종 계산된 경비보다 크다면
               System.out.println("◆ 예상 경비가 " + (getMoney - expCal) + "만큼 남습니다.");
            } else {// 입력한 경비가 최종 계산된 경비보다 작다면
               System.out.println("◆ 예상 경비가 " + -(getMoney - expCal) + "만큼 부족합니다.");
            }
            System.out.println("=========================================================");
         }
         System.out.println("");

      }
   }

}