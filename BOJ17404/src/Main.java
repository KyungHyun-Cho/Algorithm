import java.util.*;
import java.lang.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int INF = 1000000;
		int n = sc.nextInt();
		int answer = INF;
		int[][] map = new int[n][3];
		int[][] dp = new int[n][3];
		for(int i = 0; i < n; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			map[i][2] = sc.nextInt();			
		}
		for(int k = 0; k < 3; k++) {
			for(int i = 0; i < 3; i++) {
				if(i == k) dp[0][i] = map[0][i];
				else dp[0][i] = INF;
			}
			
			for(int i = 1; i < n; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
				
			}
			
			for(int i = 0 ; i < 3; i++) {
				if(i != k) answer = Math.min(answer, dp[n-1][i]);
			}
		}
		System.out.println(answer);
	}

}
