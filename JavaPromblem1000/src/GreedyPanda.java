import java.util.Scanner;
public class GreedyPanda {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int [][]arr = new int[num+2][num+2];
		for(int i=1; i<arr.length-1 ; i++)
		{
			for(int j=1 ; j<arr.length-1 ;j++)
			{
				arr[i][j] = sc.nextInt();				
			}
		}

		for(int i=0 ; i<arr.length ; i++)
		{
			arr[i][0] = -1;
		}
		for(int i=0 ; i<arr.length ; i++)
		{
			arr[i][arr.length-1] = -1;
		}
		for(int i=0 ; i<arr.length ; i++)
		{
			arr[0][i] = -1;
		}
		for(int i=0 ; i<arr.length ; i++)
		{
			arr[arr.length-1][i] = -1;
		}


		Penda p = new Penda();
		int max_life = 0;  

		for(int i=1; i<arr.length-1 ; i++)
		{
			for(int j=1; j<arr.length-1 ;j++)
			{
				p.Penda_move(i, j, arr);
				if(max_life<p.max_life){
					max_life=p.max_life;
				}
				p.max_life = 1;
			}
		}

		System.out.println(max_life);
	}


}
class GreedyPanda1 { // �ٸ���� �ҽ�
    private int[][] forest;
    private int size;
    private int MAX;

    private final int[] X = { 0, 1, 0, -1 };
    private final int[] Y = { 1, 0, -1, 0 };

    public GreedyPanda1(int size, int[][] forest) {
        this.size = size;
        this.MAX = size * size;
        this.forest = forest;
    }

    public int getMaximumAliveDay() {
        int result = 0;
        int temp = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                temp = findMaximumPath(i, j);
                result = temp > result ? temp : result;
                if (result == this.MAX) {
                    return result;
                }
            }
        }
        return result;
    }

    private int findMaximumPath(int x, int y) {
        int result =1;
        int nextX, nextY, temp;

        for (int i = 0; i < 4; i++) {
            temp = 0;
            nextX = x + X[i];
            nextY = y + Y[i];

            if (inForest(nextX, nextY) && forest[x][y] < forest[nextX][nextY]) {
                if ((temp = findMaximumPath(nextX, nextY)+1) > result) {
                    result = temp;
                }
            }
        }
        return result;
    }

    private boolean inForest(int x, int y) { // ���� �˻�.
        return (x >= 0 && x < size && y >= 0 && y < size);
    }
}
class Penda // greedy panda
{
	int index_x;
	int index_y;
	boolean life = true;
	int max_life = 1;

	Penda(int x, int y) { this.index_x = x; this.index_y = y; } // ������
	Penda() { this.index_x = 0; this.index_y = 0; } // ������

	void Penda_move(int x,int y, int [][]arr) // �Ǵٰ� �����δ�. (�Ǵ��� x,y��ǥ , �� ���� arr �Է�)
	{
		int Current_index = arr[x][y]; // ���� �ε��� ����

		int max_x = x; // ���� ��ǥ ����
		int max_y = y;
		int Move_index = Integer.MAX_VALUE; // �볪���� ������ �ִ밪���� �ʱ�ȭ


		if(arr[x-1][y] > Current_index && arr[x-1][y] < Move_index) // �·� ������, ���� �볪���� ������ ���纸�� Ŀ�ߵǰ� �� �� �� ���� �볪�� ������ ���� ���� ���̸� true
		{
			max_x = x-1;
			max_y = y;
			Move_index = arr[x-1][y];
		}
		if(arr[x+1][y] > Current_index && arr[x+1][y] < Move_index) // ��� ������.
		{
			max_x = x+1;
			max_y = y;
			Move_index = arr[x+1][y];
		}
		if(arr[x][y+1] > Current_index && arr[x][y+1] < Move_index) // �Ʒ��� ������
		{
			max_x = x;
			max_y = y+1;
			Move_index = arr[x][y+1];
		}
		if(arr[x][y-1] > Current_index && arr[x][y-1] < Move_index) // ���� ������
		{
			max_x = x;
			max_y = y-1;
			Move_index = arr[x][y-1];
		}

		if(max_x == x && max_y == y) // ��, �Ʒ�, �� ,�� �� ������ ��ġ�� ���ٸ� �Ҵ��� ���
		{
			this.life = false; // �Ҵ����
			return;
		}
		else  // ���� �������ٸ� �Ҵ��� life�� ����
		{
			max_life ++; 
			this.Penda_move(max_x, max_y, arr); // ������ ��ġ���� ����Լ� ȣ��
		}

	}


}

