import java.util.*;
public class Main {
	static int n;
	static int[][] dp, arr;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+1][n+1];
		arr = new int[n+1][n+1];
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
				//if(i == j) dp[i][j] = arr[i][j];
			}
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				DFS(i,j);
		
		int max = 1;
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				max = Math.max(dp[i][j], max);
		System.out.println(max);
	}
	
	public static int DFS(int x, int y) {
		if(dp[x][y] != 0)
			return dp[x][y];
		dp[x][y] = 1;
		for(int i = 0; i < 4; i++) {
			int new_x = x + dir[i][0];
			int new_y = y + dir[i][1];
			if(new_x >= 1 && new_x <= n && new_y >= 1 && new_y <= n) {
				if(arr[new_x][new_y] > arr[x][y]) {
					dp[x][y] = Math.max(dp[x][y], DFS(new_x,new_y)+1);
				}
			}
		}
		return dp[x][y];
	}
}
