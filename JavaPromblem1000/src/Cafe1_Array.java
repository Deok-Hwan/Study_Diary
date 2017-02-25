import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javafx.scene.SceneAntialiasing;



public class Cafe1_Array{
	public static String item[][] = {
	         {"아메리카노","Hot","2000"},
	         {"아메리카노","Cold","2500"},
	         {"에스프레소","-","2400"},
	         {"라떼","땅콩라떼","5000"},
	         {"라떼","돌체라떼","5200"},
	         {"라떼","카페라떼","4900"},
	         {"모카","카페모카","3700"},
	         {"모카","초콜렛모카","3800"},
	         {"모카","아이스카페모카","3900"},
	         {"모카","화이트모카","4000"},
	         {"카푸치노","-","5500"},
	         {"과일음료","오렌지블렌디드","8000"},
	         {"과일음료","바나나블렌디드","5000"},
	         {"과일음료","청포도블렌디드","5000"}
	      };
	public static int print(int sel) // 사용자가 선택한 값.
	{
		System.out.println("세부항목을 선택하세요.");
		int cnt = 0; // 세부 항목의 개수(리턴용)
		for (int i = 0; i < item.length; i++) {
			if(item[sel][0].equals(item[i][0])){ // 같은 메뉴라면
				System.out.println(item[i][1]);
				cnt++;
			}else{//메뉴가 바뀌면 탈출
				break;
			}
		}
		return cnt; //세부항목의 개수 리턴
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
exit : 	while(true){
			print(); //전체메뉴 출력
			String input = scan.nextLine(); // 메뉴 출력
			for (int i = 0; i < item.length; i++) { 
				if(item[i][0].equals(input)){ // 찾은 경우
					if(item[i][1].equals("-")){//세부 항목 없으면
						System.out.println(item[i][2]+"원");
						break exit; // 가격 출력 후 종료
					}
					//세부항목이 있는 경우
					while(true){
						int cnt = print(i);
						String subMenu = scan.nextLine();
						for (int j = i; j < i+cnt; j++) {
							//입력값과 같은 세부항목 검색
							if(item[j][1].equals(subMenu) ){
								System.out.println(item[j][2]+"원");
								break exit; 
							}
						}
						System.out.println("다시 입력하세요");
					} //end of while 세부 항목
					
				}
			}
			System.out.println("다시 입력하세요.");
		}
	
	}//end of main
	public static void print(){//전체메뉴 출력
		for (int i = 0; i < item.length; i++) {
			for (int j = 0; j < item[i].length; j++) {
				if(i!=0 && j==0 &&item[i][j].equals(item[i-1][j])){//처음이아니고, 이전의 항목과 같을 때
					System.out.print("\t");
				}else{
					System.out.print(item[i][j]+"\t");
				}
			}
			System.out.println();
		}
	}
}