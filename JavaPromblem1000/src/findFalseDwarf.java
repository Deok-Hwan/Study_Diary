
import java.util.Scanner;

public class findFalseDwarf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numOfCase =9;
		int [] arr = new int[9];
		int sumOfDwaf = 0;
		for(int i=0; i<numOfCase ; i++)
		{
			arr[i] = sc.nextInt();
			sumOfDwaf += arr[i];
		}
		MergeSort(arr,0,arr.length-1);
		
		sumOfDwaf-=100;
		boolean []findDwafArr = { true, true, true, true, true ,true ,true ,true , true};
		

		exit :	for(int i=0; i<9 ; i++)
		{
			for(int j=i+1; j<9 ; j++)
			{
				if(arr[i]+arr[j] == sumOfDwaf)
				{
					findDwafArr[i] = false;
					findDwafArr[j] = false;
					break exit ;
				}
			}
		}
		for(int i=0 ; i<arr.length ; i++)
		{
			if(findDwafArr[i] !=false)
			{
				System.out.println(arr[i]);
			}
		}
	}

	static void MergeTwoArea(int arr[], int left, int mid, int right)
	{
		int fIdx = left;
		int rIdx = mid+1;
		int i;
		
		// ���� �� ����� ���� �迭 sortArr�� ���� �Ҵ�!
		int []sortArr = new int[right+1];
		int sIdx = left;
		
		while(fIdx <= mid && rIdx <= right)
		{
			// ���� �� �� ������ �����͵��� ���Ͽ�,
			// ���� ������� sortArr�� �ϳ��� �Ű� ��´�.
			if(arr[fIdx] <= arr[rIdx]) 	
				sortArr[sIdx] = arr[fIdx++];
			else
				sortArr[sIdx] = arr[rIdx++]; 
			
			sIdx++;
		}
		
		if(fIdx > mid) // �迭�� �պκ��� ��� sortArr�� �Ű� ���ٸ�,
		{
			// �迭�� �޺κп� ���� �����͵��� sortArr�� �״�� �ű��.
			for(i=rIdx; i<= right ; i++, sIdx++) 
				sortArr[sIdx] = arr[i];
		}
		else // �迭�� �޺κ��� ��� sortArr�� �Ű����ٸ�,
		{	// �迭�� �պκп� ���� �����͵��� sortArr�� �״�� �ű��.
			for(i=fIdx ; i<= mid ; i++, sIdx++)
				sortArr[sIdx] = arr[i];
		}
		
		for(i=left ; i<= right ; i++)
			arr[i] = sortArr[i];
		
	}
	
	static void MergeSort(int arr[], int left, int right)
	{
		int mid;
		
		if(left < right)
		{
			// �߰� ������ ����Ѵ�.
			mid = (left+right) /2 ;
			
			// �ѷ� ������ ������ �����Ѵ�.
			MergeSort(arr, left, mid);
			MergeSort(arr, mid+1, right);
			
			// ���ĵ� �� �迭�� �����Ѵ�.
			MergeTwoArea(arr,  left,  mid, right);
			
		} // ���� ���� �� ���� ��-�� O(nlog2n) , �̵����� O(nlong2n)
	}
	
}
