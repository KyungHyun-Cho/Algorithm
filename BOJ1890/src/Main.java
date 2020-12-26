import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		long[][] dp = new long[n+1][n+1];
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				arr[i][j] = sc.nextInt();
		dp[1][1] = 1;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == n && j == n) {
					System.out.println(dp[n][n]);
				}
				if(dp[i][j] != 0) {
					//i,j�� �� �� �ִ� �Ÿ����
					int new_i = i + arr[i][j];
					int new_j = j + arr[i][j];
					if(new_i <= n) {
						//�����ϴ� ��ǥ�� ���� ���� �ִٸ�
						dp[new_i][j]+=dp[i][j];
					}
					if(new_j <= n) {
						//�����ϴ� ��ǥ�� ���� ���� �ִٸ�
						dp[i][new_j]+=dp[i][j];
					}
				}
			}
		}
		
	}
}
