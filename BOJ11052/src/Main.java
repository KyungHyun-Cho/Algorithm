import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int[] arr = new int[n+1];
		for(int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();
		dp[1] = arr[1];
		dp[2] = Math.max(arr[2], 2*arr[1]);
		for(int i = 3; i <= n; i++) {
			dp[i] = arr[i];
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
			}
		}
		System.out.println(dp[n]);
	}

}
