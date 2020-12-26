import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();		
		int[][] dp = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
		}
		
		for(int i = 3; i <= n; i++) {
			for(int j = 2; j <= (i+1)/2; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % 1_000_000_003;
			}
		}
		
		System.out.println((dp[n-3][k-1] + dp[n-1][k]) % 1_000_000_003);
	}
}
