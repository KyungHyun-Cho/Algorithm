import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		long[][] dp = new long[100001][2];
		dp[1][1] = 1;
		dp[2][0] = 1; // Â¦¼ö
		dp[2][1] = 1; // È¦¼ö
		dp[3][0] = 2;
		dp[3][1] = 2;
		for(int i = 4; i <= 100000; i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-2][1] + dp[i-3][1]) % 1_000_000_009;
			dp[i][1] = (dp[i-1][0] + dp[i-2][0] + dp[i-3][0]) % 1_000_000_009;
		}
		for(int i = 0; i < n; i++) {
			int t = stoi(br.readLine());
			long odd = dp[t][1] % 1_000_000_009;
			long even = dp[t][0] % 1_000_000_009;
			
			sb.append(odd + " " + even + "\n");
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}

}
