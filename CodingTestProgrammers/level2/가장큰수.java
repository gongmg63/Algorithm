package level2;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        QuickSort.sort(numbers);

        for(int i=numbers.length-1; i>=0; i--)
            sb.append(numbers[i]);
        if(numbers[numbers.length - 1] == 0)
            return "0";
        return sb.toString();
    }
}
class QuickSort {
	public static void sort(int[] a) {      // 호출 함수 QuickSort.sort(array);
		pivot_sort(a, 0, a.length - 1);
	}
	
	private static void pivot_sort(int[] a, int lo, int hi) {   // pivot 설정 후 sort (pivot 증식을 위해 구현)
		if(lo >= hi) {
			return;
		}
		
		int pivot = partition(a, lo, hi);	
		
		pivot_sort(a, lo, pivot - 1);       // 1회 sort 후 pivot 양 옆으로 나눠서 2개의 pivot sort로 증식 
		pivot_sort(a, pivot + 1, hi);
	}
	
	private static int partition(int[] a, int left, int right) {    // 실질적 Quick Sort 알고리즘
		int lo = left;
		int hi = right;
		int pivot = a[left];
		
		while(lo < hi) {
			
			while(compare(a[hi], pivot) && lo < hi) {
				hi--;
			}

			while(!compare(a[lo], pivot) && lo < hi) {
				lo++;
			}
			
			swap(a, lo, hi);
		}
		swap(a, left, lo);
		
		return lo;
	}
    private static boolean compare(int a, int b){
        String a1 = String.valueOf(a);
        String b1 = String.valueOf(b);

        if(Integer.parseInt(a1+b1) > Integer.parseInt(b1+a1)){
            return true;
        }
        else {
            return false;
        }
    }

	private static void swap(int[] a, int i, int j) {   // 수 바꾸기 함수
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
public class 가장큰수 {
    
}
