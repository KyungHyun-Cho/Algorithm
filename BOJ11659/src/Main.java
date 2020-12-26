import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] str;
		str = br.readLine().split(" ");
		int n = stoi(str[0]);
		int m = stoi(str[1]);
		str = br.readLine().split(" ");
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		for(int i = 0; i < n; i++)
			arr[i+1] = stoi(str[i]);
		for(int i = 1; i <= n; i++) {
			dp[i] = dp[i-1] + arr[i];			
		}
		for(int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int p = stoi(str[0]);
			int q = stoi(str[1]);
			int diff = q-p+1;
			sb.append(dp[q]-dp[p-1] + "\n");
		}
		System.out.println(sb.toString());
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
