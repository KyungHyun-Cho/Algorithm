import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 987654321;
		}

		dp[0] = 0;
		for(int i = 0; i < n; i++) {
			int available = arr[i];
			for(int j = 1; j <= available; j++) {
				if(i+j < n)
					dp[i+j] = Math.min(dp[i+j], dp[i]+1);
			}
		}
		if(dp[n-1] == 987654321)
			System.out.println(-1);
		else
			System.out.println(dp[n-1]);
	}
}
