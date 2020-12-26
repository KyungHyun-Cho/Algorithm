import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr_str = br.readLine().split(" ");
		int n = stoi(arr_str[0]);
		int k = stoi(arr_str[1]);
		int[] arr = new int[n+1];
		int[] dp = new int[k+1];
		dp[0] = 1;
		for(int i = 1; i <= n; i++)
			arr[i] = stoi(br.readLine());
		for(int i = 1; i <= n; i++) {
			for(int j = arr[i]; j <= k; j++) {
				dp[j] += dp[j-arr[i]];
			}
		}
		System.out.println(dp[k]);
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}