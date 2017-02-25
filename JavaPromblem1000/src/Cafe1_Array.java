import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javafx.scene.SceneAntialiasing;



public class Cafe1_Array{
	public static String item[][] = {
	         {"�Ƹ޸�ī��","Hot","2000"},
	         {"�Ƹ޸�ī��","Cold","2500"},
	         {"����������","-","2400"},
	         {"��","�����","5000"},
	         {"��","��ü��","5200"},
	         {"��","ī���","4900"},
	         {"��ī","ī���ī","3700"},
	         {"��ī","���ݷ���ī","3800"},
	         {"��ī","���̽�ī���ī","3900"},
	         {"��ī","ȭ��Ʈ��ī","4000"},
	         {"īǪġ��","-","5500"},
	         {"��������","�����������","8000"},
	         {"��������","�ٳ��������","5000"},
	         {"��������","û���������","5000"}
	      };
	public static int print(int sel) // ����ڰ� ������ ��.
	{
		System.out.println("�����׸��� �����ϼ���.");
		int cnt = 0; // ���� �׸��� ����(���Ͽ�)
		for (int i = 0; i < item.length; i++) {
			if(item[sel][0].equals(item[i][0])){ // ���� �޴����
				System.out.println(item[i][1]);
				cnt++;
			}else{//�޴��� �ٲ�� Ż��
				break;
			}
		}
		return cnt; //�����׸��� ���� ����
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
exit : 	while(true){
			print(); //��ü�޴� ���
			String input = scan.nextLine(); // �޴� ���
			for (int i = 0; i < item.length; i++) { 
				if(item[i][0].equals(input)){ // ã�� ���
					if(item[i][1].equals("-")){//���� �׸� ������
						System.out.println(item[i][2]+"��");
						break exit; // ���� ��� �� ����
					}
					//�����׸��� �ִ� ���
					while(true){
						int cnt = print(i);
						String subMenu = scan.nextLine();
						for (int j = i; j < i+cnt; j++) {
							//�Է°��� ���� �����׸� �˻�
							if(item[j][1].equals(subMenu) ){
								System.out.println(item[j][2]+"��");
								break exit; 
							}
						}
						System.out.println("�ٽ� �Է��ϼ���");
					} //end of while ���� �׸�
					
				}
			}
			System.out.println("�ٽ� �Է��ϼ���.");
		}
	
	}//end of main
	public static void print(){//��ü�޴� ���
		for (int i = 0; i < item.length; i++) {
			for (int j = 0; j < item[i].length; j++) {
				if(i!=0 && j==0 &&item[i][j].equals(item[i-1][j])){//ó���̾ƴϰ�, ������ �׸�� ���� ��
					System.out.print("\t");
				}else{
					System.out.print(item[i][j]+"\t");
				}
			}
			System.out.println();
		}
	}
}