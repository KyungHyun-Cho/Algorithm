import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 0; t < tc; t++) {
			int n = sc.nextInt();
			long[] dp = new long[n+3];
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			for(int i = 4; i <= n; i++) {
				dp[i] = (dp[i-2] + dp[i-3]);
			}
			System.out.println(dp[n]);
		}
	}

}
