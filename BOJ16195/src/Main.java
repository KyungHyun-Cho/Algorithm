import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		long[][] dp = new long[1001][1001];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 2;
		dp[3][3] = 1;
		for(int i = 4; i <= 1000; i++) {
			for(int j = 2; j < i; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1]) % 1_000_000_009;
			}
			dp[i][i] = 1;
		}
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int first = stoi(input[0]);
			int second = stoi(input[1]);
			long sum = 0;
			for(int j = 1; j <= second; j++) {
				sum = (sum + dp[first][j]) % 1_000_000_009;
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}

}
