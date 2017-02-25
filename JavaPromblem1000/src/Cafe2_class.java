import java.util.Scanner;

public class Cafe2_class {

	public static Item item[] = {
			new Item("아메리카노", new Item[]{
					new Item("Hot", 2000),
					new Item("Cold", 2500),
			}),
			new Item("에스프레소", 2400),
			new Item("라떼", new Item[]{
					new Item("땅콩라떼", 5000),
					new Item("돌체라떼", 5200),
					new Item("카페라떼", 4900),
			}),
			
			new Item("모카", new Item[]{
					new Item("카페모카", 3700),
					new Item("초콜렛모카", 3800),
					new Item("아이스카페모카", 3900),
					new Item("화이트모카", 4000),
			}),
			new Item("카푸치노", 5500),
			new Item("과일음료", new Item[]{
					new Item("오렌지블렌디드", 8000),
					new Item("바나나블렌디드", 5000),
					new Item("청포도블렌디드", 5000),
			})
	};

	public static void printMenu(){
		System.out.println("<메뉴표>");
		for(int i=0 ; i<item.length ; i++){
			item[i].printItem();
		}
	}
	public static int select(Item item[]){ // 사용자가 고른 항목을 리턴
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("[고를항목]");
			for (int i = 0; i < item.length; i++) {
				System.out.println(item[i].name);
			}
			String input = scan.nextLine(); // 입력 받기
			for (int i = 0; i < item.length; i++) {
				if(item[i].name.equals(input)){
					return i; // 찾은 목록의 index
				}
			}
			System.out.println("다시 입력 하세요."); //입력 못 찾은 경우.
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMenu();
		int sel = select(item);
		if(item[sel].subItem == null) // 세부항목 없음.
		{
			item[sel].printItem();
		}else{ // 세부항목이 있는 경우
			select(item[sel].subItem);
			int sel2= select(item[sel].subItem);
			System.out.println(item[sel2].name);
			item[sel].subItem[sel2].printItem();
		}
	}
}
class Item{
	String name = "";
	int price ;
	Item subItem[];

	public Item(){

	}
	public Item(String name, int price){
		this.name = name;
		this.price = price;
	}
	public Item(String name, Item subItem[]){
		this.name = name;
		this.subItem = subItem;
	}
	public void printItem(){
		if(subItem == null)
		{
			System.out.println(name+":"+price+"원");
		}
		else{
			System.out.print(name); // name은 한번 만 출력하고
			for(int i=0 ; i<subItem.length ;i++)
			{
				System.out.print("\t"); // \t 는 누적되서 출력되지 않는다.
				subItem[i].printItem(); // subItem이 있다면 재귀 함수를 호출한다.
			}
		}
	}
}
