import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] dp = new int[n+1][n+2];
		dp[1][1] = 1;
		dp[1][2] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i+1; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}
		System.out.println(dp[n][k+1]);
	}
}
