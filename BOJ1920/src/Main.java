import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		String[] arr1_str = br.readLine().split(" ");
		for(int i = 0; i < n; i++)
			arr1[i] = Integer.parseInt(arr1_str[i]);
		Arrays.sort(arr1);
		int m = Integer.parseInt(br.readLine());
		String[] arr2_str = br.readLine().split(" ");
		for(int i = 0; i < m; i++) {
			int k = Integer.parseInt(arr2_str[i]);
			System.out.println(binarySearch(arr1, 0, n-1, k));
		}
		
		
		
	}
	public static int binarySearch(int[] arr, int l, int r, int search) {
		int p = (l+r)/2;
		if(arr[p] == search) {
			//찾는 값 나옴
			return 1;
		}else {
			if(l >= r) {
				//결국 못찾음
				return 0;
			}else {
				if(arr[p] > search) {
					//찾는 값이 현재 값보다 작다면, 이전 범위를 탐색해야함
					return binarySearch(arr, l, p-1, search);
				}else {
					//찾는 값이 현재 값보다 크다면, 다음 범위를 탐색해야함
					return binarySearch(arr, p+1, r, search);
				}
			}
		}
		
	}
}
