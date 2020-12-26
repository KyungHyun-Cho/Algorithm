import java.util.Scanner;
import java.lang.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n+2];
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1]*2 + (i%2==0?1:-1))%10007;
		}
		System.out.println(dp[n]);
	}
}
