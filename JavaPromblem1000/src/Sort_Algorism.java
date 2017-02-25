import java.util.Arrays;

public class Sort_Algorism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("!!!!!!!!!!!!!!!!");
		
		int [] arr = {-1, -2 , -100, 0 , 100, 511111};
		QuickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	static void Select_Sort(int arr[], int n) // ���� �˰���
	{
		int i,j;
		int maxIdx;
		int temp;
		
		for(i=0; i<n-1  ;i++)
		{
			maxIdx = i;
			
			for(j=i+1 ; j<n ; j++) // �ּڰ� Ž��
			{
				if(arr[j] < arr[maxIdx])
					maxIdx = j;
				
			}
			temp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = temp;
			
		}
	} // ���þ˰��� �񱳿����� Ƚ�� O(n^2) , �̵����� Ƚ�� O(n) 
	
	static void InserSort(int arr[], int n)
	{
		int i,j;
		int insData;
		
		for(i=1 ; i<n ; i++)
		{
			insData = arr[i]; // ���� ����� insData�� ����
			
			for(j=i-1 ; j>=0 ; j--)
			{
				if(arr[j] > insData)
					arr[j+1] = arr[j]; // �񱳴�� �� ĭ �ڷ� �б�
				else
					break; // ������ġ ã������ Ż��!
				
			}
			
			arr[j+1] = insData; // ã�� ��ġ�� ���Ĵ�� ����!
		}
		
	}	// �־��� ���� ������ ����� ���̰� ���̳�. �־��� ��� �� ����� O(n^2) �߻�
	
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
	static void Swap(int arr[], int idx1, int idx2)
	{
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	static int Partition(int arr[], int left , int right)
	{
		int pivot = arr[left];	// �ǹ��� ��ġ�� ���� ����!
		int low = left+1;	
		int high = right;
		
		while(low <= high)	// �������� ���� ������ �ݺ�
		{
			while(pivot >= arr[low] && low <= right) 
				low++;	// low�� ���������� �̵�
			while(pivot <= arr[high] && high >= (left+1)) 
				high--; // high�� �������� �̵�
			
			// �������� ���� ���¶�� Swap ����
			if(low <= high)	
				Swap(arr, low , high);
		}
		Swap(arr, left, high); // �ǹ���  high�� ����Ű�� ��� ��ȯ
		return high;		// �Ű��� �ǹ��� ��ġ���� ��ȯ
	}
	
	static void QuickSort(int arr[], int left , int right)
	{
		if(left <= right)
		{
			int pivot = Partition(arr,  left,  right); // �ѷ� ������
			QuickSort(arr, left, pivot -1);			   // ���� ������ ����
			QuickSort(arr, pivot+1, right);			   // ������ ������ ����
			
		}
	}
	
	
	
}
