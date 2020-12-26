import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+3];
		dp[0] = 1; dp[2] = 3;
		for(int i = 4; i <= n; i += 2) {
			dp[i] = 3*dp[i-2];
			for(int j = 0; j <= i-4; j += 2) {
				dp[i] += 2*dp[j];
			}
		}
		System.out.println(dp[n]);
	}
}
