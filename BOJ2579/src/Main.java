import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = arr[1];
		if(n >= 2)
			dp[2] = Math.max(arr[2], arr[1]+arr[2]);
		if(n >= 3)
			dp[3] = Math.max(arr[2] + arr[3], arr[1]+arr[3]);
		for(int i = 4; i <= n; i++)
			dp[i] = Math.max(arr[i] + arr[i-1] + dp[i-3], arr[i] + dp[i-2]);
		System.out.println(dp[n]);
	}
}
