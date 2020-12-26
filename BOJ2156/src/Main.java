import java.util.Scanner;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+3];
		int[] dp = new int[n+3];
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max(Math.max(arr[1] + arr[3], arr[2] + arr[3]), dp[2]);
		for(int i = 4; i <= n; i++) {
			dp[i] = Math.max(Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]), dp[i-1]);
		}
		System.out.println(dp[n]);
	}
}
