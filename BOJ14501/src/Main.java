import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[21];
		for(int i = 0;i < n; i++) {
			int d = sc.nextInt();
			int c = sc.nextInt();
			dp[i+1] = Math.max(dp[i], dp[i+1]);
			dp[i+d] = Math.max(dp[i+d], dp[i]+c);
		}
		System.out.println(dp[n]);
	}
}
