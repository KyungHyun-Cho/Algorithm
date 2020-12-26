import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] dp = new int[k+1][n+1];
		Arrays.fill(dp[1], 1);
		for(int i = 1; i <= k; i++) {
			dp[i][1] = i;
		}
		for(int i = 2; i <= k; i++) {
			for(int j = 2; j <= n; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
			}
		}
		System.out.println(dp[k][n]);
	}
}
