import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] dp = new int[31][32];
		dp[1][1] = dp[1][2] = 1;
		for(int i = 2; i <= 30; i++) {
			for(int j = 1; j <= i+1; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		for(int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(dp[m][n+1]);
		}
	}

}
