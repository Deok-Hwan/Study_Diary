import java.util.Arrays;

public class Sort_Algorism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("!!!!!!!!!!!!!!!!");
		
		int [] arr = {-1, -2 , -100, 0 , 100, 511111};
		QuickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	static void Select_Sort(int arr[], int n) // 선택 알고리즘
	{
		int i,j;
		int maxIdx;
		int temp;
		
		for(i=0; i<n-1  ;i++)
		{
			maxIdx = i;
			
			for(j=i+1 ; j<n ; j++) // 최솟값 탐색
			{
				if(arr[j] < arr[maxIdx])
					maxIdx = j;
				
			}
			temp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = temp;
			
		}
	} // 선택알고리즘 비교연산의 횟수 O(n^2) , 이동연산 횟수 O(n) 
	
	static void InserSort(int arr[], int n)
	{
		int i,j;
		int insData;
		
		for(i=1 ; i<n ; i++)
		{
			insData = arr[i]; // 정렬 대상을 insData에 저장
			
			for(j=i-1 ; j>=0 ; j--)
			{
				if(arr[j] > insData)
					arr[j+1] = arr[j]; // 비교대상 한 칸 뒤로 밀기
				else
					break; // 삽입위치 찾았으니 탈출!
				
			}
			
			arr[j+1] = insData; // 찾은 위치에 정렬대상 삽입!
		}
		
	}	// 최악의 경우와 최적의 경우의 차이가 많이남. 최악의 경우 빅 엔디안 O(n^2) 발생
	
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
	static void Swap(int arr[], int idx1, int idx2)
	{
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	static int Partition(int arr[], int left , int right)
	{
		int pivot = arr[left];	// 피벗의 위치는 가장 왼쪽!
		int low = left+1;	
		int high = right;
		
		while(low <= high)	// 교차되지 않을 때까지 반복
		{
			while(pivot >= arr[low] && low <= right) 
				low++;	// low를 오른쪽으로 이동
			while(pivot <= arr[high] && high >= (left+1)) 
				high--; // high를 왼쪽으로 이동
			
			// 교차되지 않은 상태라면 Swap 실행
			if(low <= high)	
				Swap(arr, low , high);
		}
		Swap(arr, left, high); // 피벗과  high가 가리키는 대상 교환
		return high;		// 옮겨진 피벗의 위치정보 반환
	}
	
	static void QuickSort(int arr[], int left , int right)
	{
		if(left <= right)
		{
			int pivot = Partition(arr,  left,  right); // 둘로 나눠서
			QuickSort(arr, left, pivot -1);			   // 왼쪽 영역을 정렬
			QuickSort(arr, pivot+1, right);			   // 오른쪽 영역을 정렬
			
		}
	}
	
	
	
}
