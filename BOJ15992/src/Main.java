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
			//j = 1���� �������� �ʴ� ������, ������ i >= 4����, 1���� �������� i�� ���� �� �ִ� ���� ����.
			//��, 1���� �������� 4 �̻��� ����� ���� ���� ����.
			for(int j = 2; j < i; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1]) % 1_000_000_009;
			}
			//dp[i][i] = 1�� ������, i�� ����� ���� i���� ������ ����ϴ� ����
			//1+1+1+1+1+... (1�� �� i�� �������� ���)�ۿ� ���� ����.
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
