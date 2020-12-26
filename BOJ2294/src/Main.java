import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		for(int[] item : dp)
			Arrays.fill(item, 100000);
		
		for(int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= k; j++) 
				if(j % arr[i] == 0) dp[i][j] = j/arr[i];
		
		for(int i = 1; i <= n; i++) { // i번째 동전까지만 사용했을 때
			for(int j = 1; j <= k; j++) { // j원을 만들기 위한 dp배열
				dp[i][j] = Math.min(dp[i-1][j],dp[i][j]);
				if(j % arr[i] == 0) {
					dp[i][j] = Math.min(dp[i][j], j/arr[i]);
				}else {
					for(int l = 1; arr[i]*l < j; l++) 
						dp[i][j] = Math.min(dp[i][j], dp[i][arr[i]*l] + dp[i][j-arr[i]*l]);
				}
			}
		}
		if(dp[n][k] > 100000) System.exit(1);
		System.out.println(dp[n][k]==100000?-1:dp[n][k]);
	}
}
