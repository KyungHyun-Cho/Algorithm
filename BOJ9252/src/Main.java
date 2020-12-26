import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = " " + sc.next();
		String str2 = " " + sc.next();
		int n = str1.length()-1;
		int m = str2.length()-1;
		int max = Integer.MIN_VALUE;
		String max_str = "";
		int[][] dp = new int[n+1][m+1];
		String[][] str_dp = new String[n+1][m+1];
		for(String[] item : str_dp)
			Arrays.fill(item, "");
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1]+1;
					str_dp[i][j] = str_dp[i-1][j-1] + str1.charAt(i);
				}else {
					if(dp[i-1][j] > dp[i][j-1]) {
						dp[i][j] = dp[i-1][j];
						str_dp[i][j] = str_dp[i-1][j];
					}else{
						dp[i][j] = dp[i][j-1];
						str_dp[i][j] = str_dp[i][j-1];				
					}
				}
				if(dp[i][j] > max) {
					max = dp[i][j];
					max_str = str_dp[i][j];
				}
			}
		}
		System.out.println(max);
		System.out.println(max_str);
		sc.close();
	}
}
