import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		for(int i = 1; i*i <= n; i++) {
			for(int j = 1; j*i*i <= n; j++) {
				dp[j*i*i] = j;
			}
		}
		for(int i = 3; i <= n; i++) {
			if(dp[i] != 1) {
				int sqrt_num = (int)Math.pow((int)Math.floor(Math.sqrt(i)),2);
				dp[i] = Math.min(dp[i], dp[i-sqrt_num]+1);
			}
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 2; j*j <= i; j++)
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
		}
		System.out.println(dp[n]);
	}
}
