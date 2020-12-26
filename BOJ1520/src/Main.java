import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
	static int n, m;
	static int[][] map;
	static int[][] dp;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		for(int[] row:dp)
			Arrays.fill(row, -1);
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				map[i][j] = sc.nextInt();
			}			
		}
		System.out.println(DFS(1,1));
		sc.close();
		
	}
	public static int DFS(int x, int y) {
		if(dp[x][y] != -1) return dp[x][y];
		if(x == n && y == m) return 1;

		dp[x][y] = 0;
		for(int i = 0; i < 4; i++) {
			int new_x = x + dir[i][0];
			int new_y = y + dir[i][1];
			if(new_x > 0 && new_y > 0 && new_x <= n && new_y <= m && map[x][y] > map[new_x][new_y]) {
				dp[x][y] += DFS(new_x,new_y);
			}
		}
		return dp[x][y];
	}
}
