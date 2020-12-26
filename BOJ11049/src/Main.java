import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][n+1];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			arr[i+1] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++) {
			for(int j = i+1; j <= n; j++) {
				int new_i = j-i;
				if(new_i == 1 && j == 3) {
					System.out.println("BP");
				}
				int min = Integer.MAX_VALUE;
				for(int k = new_i; k <= j-1; k++) {
					min = Math.min(min, dp[new_i][k]+dp[k+1][j] + arr[new_i-1]*arr[k]*arr[j]);
				}
				dp[new_i][j] = min;
			}
		}
		System.out.println(dp[1][n]);
	}
}
