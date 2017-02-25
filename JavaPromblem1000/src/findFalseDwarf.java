
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
		
		// 병합 한 결과를 담을 배열 sortArr의 동적 할당!
		int []sortArr = new int[right+1];
		int sIdx = left;
		
		while(fIdx <= mid && rIdx <= right)
		{
			// 병합 할 두 영역의 데이터들을 비교하여,
			// 정렬 순서대로 sortArr에 하나씩 옮겨 담는다.
			if(arr[fIdx] <= arr[rIdx]) 	
				sortArr[sIdx] = arr[fIdx++];
			else
				sortArr[sIdx] = arr[rIdx++]; 
			
			sIdx++;
		}
		
		if(fIdx > mid) // 배열의 앞부분이 모두 sortArr에 옮겨 졌다면,
		{
			// 배열의 뒷부분에 남은 데이터들을 sortArr에 그대로 옮긴다.
			for(i=rIdx; i<= right ; i++, sIdx++) 
				sortArr[sIdx] = arr[i];
		}
		else // 배열의 뒷부분이 모두 sortArr에 옮겨졌다면,
		{	// 배열의 앞부분에 남은 데이터들을 sortArr에 그대로 옮긴다.
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
			// 중간 지점을 계산한다.
			mid = (left+right) /2 ;
			
			// 둘로 나눠서 각각을 정렬한다.
			MergeSort(arr, left, mid);
			MergeSort(arr, mid+1, right);
			
			// 정렬된 두 배열을 병합한다.
			MergeTwoArea(arr,  left,  mid, right);
			
		} // 병합 정렬 비교 연산 빅-오 O(nlog2n) , 이동연산 O(nlong2n)
	}
	
}
