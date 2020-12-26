import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] dp2 = new int[n];
		
		int max = Integer.MIN_VALUE;		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			int t = 0;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					t = Math.max(t, dp[j]);
				}
			}
			dp[i] = t+1;
		}
		for(int i = n-1; i >= 0; i--) {
			int t = 0;
			for(int j = n-1; j > i; j--) {
				if(arr[i] > arr[j]) {
					t = Math.max(t, dp2[j]);
				}
			}
			dp2[i] = t+1;
		}
		for(int i = 0; i < n; i++) {
			int tmpmax = dp[i] + dp2[i] - 1;
			if(tmpmax > max) max = tmpmax;
		}
		System.out.println(max);
	}
}
