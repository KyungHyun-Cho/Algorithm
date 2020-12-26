import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= i; j++)
				arr[i][j] = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
			}
		}
		int[] tmp_arr = new int[n];
		for(int i = 0; i < n; i++) {
			tmp_arr[i] = dp[n][i+1];
		}
		Arrays.sort(tmp_arr);
		System.out.println(tmp_arr[n-1]);
	}
}
