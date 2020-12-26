import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] mem_arr = new int[n];
		int[] cost_arr = new int[n];
		int cost_max = 0;
		for(int i = 0; i < n; i++)
			mem_arr[i] = sc.nextInt();
		for(int i = 0; i < n; i++) {
			cost_arr[i] = sc.nextInt();
			cost_max += cost_arr[i];
		}
		int[] dp = new int[cost_max + 1];
		Arrays.fill(dp, -1);
		for(int i = 0; i < n; i++) {
			int now_cost = cost_arr[i];
			for(int j = cost_max ; j >= now_cost; j--) {
				if(dp[j-now_cost] != -1) {
					dp[j] = Math.max(dp[j], dp[j-now_cost] + mem_arr[i]);
				}
			}
			dp[now_cost] = Math.max(dp[now_cost], mem_arr[i]);
		}
		for(int i = 0; i <= dp.length; i++) {
			if(dp[i] >= m) {
				System.out.println(i);
				break;
			}
		}
		sc.close();
	}
}