import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][10];
		Arrays.fill(dp[1], 1);
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= 9; j++) {
				int sum = 0;
				for(int k = 0; k <= j; k++) {
					sum = ((sum + dp[i-1][k]) % 10007);
				}
				dp[i][j] = sum;
			}
		}
		int sum = 0;
		for(int i = 0; i <= 9; i++)
			sum = ((sum + dp[n][i]) % 10007);
		System.out.println(sum);
	}
}
