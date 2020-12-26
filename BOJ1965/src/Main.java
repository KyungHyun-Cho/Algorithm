import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			if(dp[i] > max) max = dp[i];
		}
		System.out.println(max);
		sc.close();
	}
}
