import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		merge_sort(arr, 0, arr.length-1);
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
	public static void merge_sort(int[] arr, int i, int j) {
		if(i < j) {
			int mid = (i+j)/2;
			merge_sort(arr, i, mid);
			merge_sort(arr, mid+1, j);
			merge(arr, i, mid, j);
		}
	}
	public static void merge(int[] arr, int i, int j, int k) {
		int p = i;
		int q = j+1;
		int r = p;
		int[] tmp = new int[arr.length];
		while(p <= j || q <= k) {
			if(q > k || (p <= j && arr[p] < arr[q]))
				tmp[r++] = arr[p++];
			else
				tmp[r++] = arr[q++];
		}
		for(int t = i; t < r; t++)
			arr[t] = tmp[t];
	}
}
