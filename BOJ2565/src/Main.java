import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		int[] dp = new int[n];
		int max = -1;
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();			
		}
		Arrays.sort(arr, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for(int i = 0; i < n; i++) {
			int t = 0;
			for(int j = 0; j < i; j++) {
				if(arr[i][1] > arr[j][1]) {
					t = Math.max(t, dp[j]);
				}
			}
			dp[i] = t+1;
			if(dp[i] > max) max = dp[i];
		}
		System.out.println(n-max);
	}
}
