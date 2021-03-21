import java.io.*;
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
			//j = 1부터 시작하지 않는 이유는, 어차피 i >= 4에서, 1개의 수식으로 i를 만들 수 있는 경우는 없음.
			//즉, 1개의 수식으로 4 이상을 만드는 경우는 없기 때문.
			for(int j = 2; j < i; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1]) % 1_000_000_009;
			}
			//dp[i][i] = 1인 이유는, i를 만들기 위해 i개의 수식을 사용하는 경우는
			//1+1+1+1+1+... (1이 총 i번 더해지는 경우)밖에 없기 때문.
			dp[i][i] = 1;
		}
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int first = stoi(input[0]);
			int second = stoi(input[1]);
			sb.append(dp[first][second] + "\n");
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}

}
