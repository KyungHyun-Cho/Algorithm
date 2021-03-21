import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] dp = new String[13];
		dp[0] = "-";
		for(int i = 1; i <= 12; i++) {
			dp[i] = makeK(dp[i-1]);
		}
		String input;
		while((input = br.readLine()) != null) {
			int n = stoi(input);
			sb.append(dp[n] + "\n");
		}
		System.out.println(sb);
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static String makeK(String str) {
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		sb.append(str);
		for(int i = 0; i < len; i++)
			sb.append(' ');
		sb.append(str);
		return sb.toString();
	}
}
