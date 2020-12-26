import java.lang.*;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] dp = new int[n+3];
		String[] sb_arr = new String[n+3];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		sb_arr[1] = "1";
		sb_arr[2] = "2 1";
		sb_arr[3] = "3 1";
		
		for(int i = 4; i <= n; i++) {
			//sb.append(i + " ");
			if(i % 3 == 0 && i % 2 == 0) {
				int tmp1 = dp[i/3]+1;
				int tmp2 = dp[i/2]+1;
				int tmp3 = dp[i-1]+1;
				if(tmp1 <= tmp2) {
					if(tmp3 <= tmp1) {
						sb_arr[i] = i + " " + sb_arr[i-1];
						dp[i] = tmp3;
					}else {
						sb_arr[i] = i + " " + sb_arr[i/3];
						dp[i] = tmp1;
					}
				}else {
					if(tmp3 <= tmp1) {
						sb_arr[i] = i + " " + sb_arr[i-1];
						dp[i] = tmp3;
					}else {
						sb_arr[i] = i + " " + sb_arr[i/2];
						dp[i] = tmp2;
					}
				}
			}else if(i % 3 == 0) {
				int tmp1 = dp[i/3]+1;
				int tmp2 = dp[i-1]+1;
				if(tmp1 <= tmp2) {
					sb_arr[i] = i + " " + sb_arr[i/3];
					dp[i] = tmp1;
				}else {
					sb_arr[i] = i + " " + sb_arr[i-1];
					dp[i] = tmp2;
				}
				dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
			}else if(i % 2 == 0) {
				int tmp1 = dp[i/2]+1;
				int tmp2 = dp[i-1]+1;
				if(tmp1 <= tmp2) {
					sb_arr[i] = i + " " + sb_arr[i/2];
					dp[i] = tmp1;
				}else {
					sb_arr[i] = i + " " + sb_arr[i-1];
					dp[i] = tmp2;
				}
				dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
			}else {
				sb_arr[i] = i + " " + sb_arr[i-1];
				dp[i] = dp[i-1] + 1;
			}
		}
		System.out.println(dp[n]);
		System.out.println(sb_arr[n]);
	}
}
