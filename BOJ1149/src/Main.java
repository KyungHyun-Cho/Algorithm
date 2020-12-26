import java.util.*;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][4];
		int[][] dp = new int[n+1][4];
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= 3; j++)
				arr[i][j] = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			dp[i][1] = Math.min(dp[i-1][2],dp[i-1][3]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][1],dp[i-1][3]) + arr[i][2];
			dp[i][3] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][3];
		}
		
		System.out.println(Math.min(Math.min(dp[n][1],dp[n][2]),dp[n][3]));
	}
}
