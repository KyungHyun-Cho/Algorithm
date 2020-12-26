import java.util.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			int t = 0;
			for(int j = 1; j < i; j++) {
				if(arr[i] > arr[j]) {
					t = Math.max(t, dp[j]);
				}
			}
			dp[i] = t + 1;
			if(dp[i] > max) max = dp[i];
		}
		System.out.println(max);
	}
}
