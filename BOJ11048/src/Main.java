import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[n+1][m+1];
		int[][] map = new int[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + map[i][j];
			}
		}
		System.out.println(dp[n][m]);
		sc.close();
	}
	public static int max(int a, int b, int c) {
		int max = b;
		if(a>b) max = a;
		if(c>max) max = c;
		return max;
	}
}
