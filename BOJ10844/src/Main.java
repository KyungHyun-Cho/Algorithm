import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[n+1][10];
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;
		for(int i = 2; i <= n; i++){
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][1] % 1000000000; 
				}else if(j == 9) {
					dp[i][j] = dp[i-1][8] % 1000000000;					
				}else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;					
				}
			}
		}
		long sum = 0;
		for(int i = 0; i <= 9; i++)
			sum = (sum + dp[n][i]) % 1000000000;
		
		System.out.println(sum);
	}

}
