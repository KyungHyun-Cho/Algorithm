import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int m = stoi(inputArr[1]);
		int[][] map = new int[m+1][n+1];
		int[][] dp = new int[m+1][n+1];
		int[][] trace = new int[m+1][n+1];
		
		
		for(int i = 1; i <= n; i++) {
			inputArr = br.readLine().split(" ");
			for(int j = 1; j <= m; j++)
				map[j][i] = stoi(inputArr[j]);
		}
		
		// i번째 회사 까지만 금액을 구하려고 한다면
		for(int j = 1; j <= n; j++) {
			// j원만큼 까지만 사용 가능할 때
			for(int i = 1; i <= m; i++) {
				// i번째 회사에서는 c만큼의 금액만 사용하는 경우
				for(int c = 0; c <= j; c++) {					
					if(dp[i][j] < dp[i-1][j-c] + map[i][c]) {
						dp[i][j] = dp[i-1][j-c] + map[i][c];
						trace[i][j] = c; 
					}
				}
			}
		}
		
		System.out.println(dp[m][n]);
		Stack<Integer> p = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = m; i > 0; i--) {
			p.add(trace[i][n]);
			n -= trace[i][n];
		}
		while(!p.isEmpty())
			sb.append(p.pop()).append(" ");
		
		System.out.println(sb.toString());
	}
	static int stoi(String str) {return Integer.parseInt(str);}	
}
