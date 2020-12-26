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
			int min_idx = binarySearchL(arr1, 0, n-1, k);
			int max_idx = binarySearchR(arr1, 0, n-1, k);
			if(min_idx != -1) {
				System.out.println(max_idx-min_idx);
			}
			else
				System.out.println(0);
			//System.out.println(tmp[0] + "," + tmp[1]);
		}
		
		
		
	}
	
	public static int binarySearch(int[] arr, int l, int r, int search) {
		int p = (l+r)/2;
		if(arr[p] == search) {
			return p;
		}else {
			if(l >= r) {
				//�ᱹ ��ã��
				return -1;
			}else {
				if(arr[p] > search) {
					//ã�� ���� ���� ������ �۴ٸ�, ���� ������ Ž���ؾ���
					return binarySearch(arr, l, p-1, search);
				}else {
					//ã�� ���� ���� ������ ũ�ٸ�, ���� ������ Ž���ؾ���
					return binarySearch(arr, p+1, r, search);
				}
			}
		}
	}
	
	public static int binarySearchL(int[] arr, int l, int r, int search) {
		if(arr[r] < search || arr[l] > search) return -1;
		while(l < r) {
			int p = (l+r)/2;
			if(arr[p] < search) // ã���� �ϴ� �����Ͱ� ���� ������ ū ���, 
				l = p + 1;
			else // ã���� �ϴ� �����Ͱ� ���� ������ ���� ���
				r = p;
		}
		
		if(arr[r] == search) 
			return r;
		else
			return -1;
	}
	
	public static int binarySearchR(int[] arr, int l, int r, int search) {
		//if(arr[r] < search || arr[l] > search) return -1;
		while(l < r) {
			int p = (l+r)/2;
			if(arr[p] <= search) // ã���� �ϴ� �����Ͱ� ���� ������ ū ���, 
				l = p + 1;
			else // ã���� �ϴ� �����Ͱ� ���� ������ ���� ���
				r = p;
		}
		
		if(arr[r-1] == search) 
			return r;
		else
			return -1;
	}
	
	public static int getCount(int[] arr, int idx) {
		int first = arr[idx];
		int cnt = 0;
		for(int i = idx; i < arr.length; i++)
			if(first == arr[i]) cnt++;
			else break;
		return cnt;
	}
}
