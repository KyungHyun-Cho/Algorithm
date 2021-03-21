import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		long[] dp = new long[100_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 3;
		dp[5] = 3;
		dp[6] = 6;
		for(int i = 7; i <= 100_000; i++) 
			dp[i] = (dp[i-2] + dp[i-4] + dp[i-6]) % 1_000_000_009;
		
		for(int i = 0; i < n; i++) {
			int t = stoi(br.readLine());
			sb.append(dp[t] + "\n");
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
