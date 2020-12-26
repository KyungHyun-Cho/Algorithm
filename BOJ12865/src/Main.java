import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[n+1][2];
		int[][] dp = new int[n+1][k+1];
		for(int i = 1; i <= n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++) {
			//i번째 물건을
			for(int j = 1; j <= k; j++) {
				//무게가 j까지인 가방에 담는 최대 갯수?
				if(arr[i][0] <= j) {
					//만약 현재 가방의 무게(j) 까지중에서 남는 공간이 있다면?
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
				}else {
					//남는 공간이 없다면(즉, 담을 수 없는 경우) 이전 가방까지에서 현재 무게의 최대값
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
