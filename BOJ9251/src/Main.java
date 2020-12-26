import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int len1 = str1.length();
		int len2 = str2.length();
		int max = -1;
		int[][] dp = new int[len1+1][len2+1];
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
					if(dp[i][j] > max) max = dp[i][j];
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
					if(dp[i][j] > max) max = dp[i][j];
				}
			}
		}
		System.out.println(max);
	}
}
