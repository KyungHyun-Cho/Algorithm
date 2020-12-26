import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		long[][] dp = new long[n+1][n+1];
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				arr[i][j] = sc.nextInt();
		dp[1][1] = 1;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == n && j == n) {
					System.out.println(dp[n][n]);
				}
				if(dp[i][j] != 0) {
					//i,j가 갈 수 있는 거리라면
					int new_i = i + arr[i][j];
					int new_j = j + arr[i][j];
					if(new_i <= n) {
						//점프하는 좌표가 범위 내에 있다면
						dp[new_i][j]+=dp[i][j];
					}
					if(new_j <= n) {
						//점프하는 좌표가 범위 내에 있다면
						dp[i][new_j]+=dp[i][j];
					}
				}
			}
		}
		
	}
}
