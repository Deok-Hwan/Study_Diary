import java.util.Scanner;

public class Cafe2_class {

	public static Item item[] = {
			new Item("�Ƹ޸�ī��", new Item[]{
					new Item("Hot", 2000),
					new Item("Cold", 2500),
			}),
			new Item("����������", 2400),
			new Item("��", new Item[]{
					new Item("�����", 5000),
					new Item("��ü��", 5200),
					new Item("ī���", 4900),
			}),
			
			new Item("��ī", new Item[]{
					new Item("ī���ī", 3700),
					new Item("���ݷ���ī", 3800),
					new Item("���̽�ī���ī", 3900),
					new Item("ȭ��Ʈ��ī", 4000),
			}),
			new Item("īǪġ��", 5500),
			new Item("��������", new Item[]{
					new Item("�����������", 8000),
					new Item("�ٳ��������", 5000),
					new Item("û���������", 5000),
			})
	};

	public static void printMenu(){
		System.out.println("<�޴�ǥ>");
		for(int i=0 ; i<item.length ; i++){
			item[i].printItem();
		}
	}
	public static int select(Item item[]){ // ����ڰ� �� �׸��� ����
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("[���׸�]");
			for (int i = 0; i < item.length; i++) {
				System.out.println(item[i].name);
			}
			String input = scan.nextLine(); // �Է� �ޱ�
			for (int i = 0; i < item.length; i++) {
				if(item[i].name.equals(input)){
					return i; // ã�� ����� index
				}
			}
			System.out.println("�ٽ� �Է� �ϼ���."); //�Է� �� ã�� ���.
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMenu();
		int sel = select(item);
		if(item[sel].subItem == null) // �����׸� ����.
		{
			item[sel].printItem();
		}else{ // �����׸��� �ִ� ���
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
			System.out.println(name+":"+price+"��");
		}
		else{
			System.out.print(name); // name�� �ѹ� �� ����ϰ�
			for(int i=0 ; i<subItem.length ;i++)
			{
				System.out.print("\t"); // \t �� �����Ǽ� ��µ��� �ʴ´�.
				subItem[i].printItem(); // subItem�� �ִٸ� ��� �Լ��� ȣ���Ѵ�.
			}
		}
	}
}
