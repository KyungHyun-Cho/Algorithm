import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		String[] str_dp = new String[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			str_dp[i] = Integer.toString(arr[i]);
		}
		Arrays.fill(dp, 1);
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				if(arr[i] > arr[j]) {
					if(dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						str_dp[i] = str_dp[j] + " " + arr[i];
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		String max_str = "";
		
		for(int i = 1; i <= n; i++) {
			if(dp[i] > max) {
				max = dp[i];
				max_str = str_dp[i];
			}
		}
		System.out.println(max);
		System.out.println(max_str);
	}

	
}
