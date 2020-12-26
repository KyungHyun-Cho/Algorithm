import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int n = stoi(br.readLine());
			int[][] map = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			for(int i = 0; i < 2; i++) {
				String[] str_arr = br.readLine().split(" ");
				for(int j = 1; j <= n; j++) {
					map[i][j] = stoi(str_arr[j-1]);
				}
			}
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			
			for(int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i];
			}
			System.out.println(Math.max(dp[0][n],dp[1][n]));
		}
		br.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
