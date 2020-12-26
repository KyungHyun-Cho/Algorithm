import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int[] arr = new int[n+1];
		int max = Integer.MIN_VALUE;
		Arrays.fill(dp, 1);
		
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
			max = Math.max(max, dp[i]);
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
	}
}
