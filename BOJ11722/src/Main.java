import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		Arrays.fill(dp, 1);
		for(int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();
		int max = 1;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				if(arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
	}
}
