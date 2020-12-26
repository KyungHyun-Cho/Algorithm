import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dp = new int[41][2];		
		int n = sc.nextInt();
		dp[0][0] = 1;
		dp[1][1] = 1;
		for(int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i-1][1];
			dp[i][1] = dp[i-1][0] + dp[i-1][1];			
		}
		for(int i = 0; i < n; i++) {
			int k = sc.nextInt();
			System.out.println(dp[k][0] + " " + dp[k][1]);
		}
	}
}
