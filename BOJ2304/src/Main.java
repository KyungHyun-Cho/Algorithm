import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max_h = Integer.MIN_VALUE;
		int max_idx = 0;
		int sum = 0;
		int arr[][] = new int[n][2];
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		for(int i = 0; i < n; i++) {
			if(max_h <= arr[i][1]) {
				max_h = arr[i][1];
				max_idx = i;
			}
		}
		int now_h = arr[0][1];
		int now_idx = arr[0][0];
		for(int i = 1; i <= max_idx; i++) {
			if(arr[i][1] >= now_h) {
				sum += (arr[i][0]-now_idx)*now_h;
				now_idx = arr[i][0]; now_h = arr[i][1];
			}
		}
		
		now_h = arr[n-1][1];
		now_idx = arr[n-1][0];
		for(int i = n-1; i >= max_idx; i--) {
			if(arr[i][1] >= now_h) {
				sum += (arr[i][0]-now_idx)*now_h*-1;
				now_idx = arr[i][0]; now_h = arr[i][1];
			}
		}
		sum += max_h;
		System.out.println(sum);
	}

}
