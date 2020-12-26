import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n];
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0] = arr[0];
		int max = arr[0];
		for(int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			if(dp[i] > max) max = dp[i];
		}
		System.out.println(max);
	}
}
