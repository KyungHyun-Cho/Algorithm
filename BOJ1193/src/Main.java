import java.util.Scanner;
public class Main {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];
		int k = 1;
		while(true) {
			dp[k] = dp[k-1] + k;
			if(dp[k] >= n) break;
			k++;
		}
		int start = dp[k-1] + 1;
		int bbsum = k+1;
		int boonja = 0, boonmo = 0;
		if(k % 2 == 1) {
			//Ȧ���� ��� ���� -> ���
			for(int i = 1; i <= k; i++) {
				boonmo = i; boonja = bbsum-i;
				if(start == n) break;
				else start++;
			}
		}else {
			//¦���� ��� : ��� -> ����
			for(int i = 1; i <= k; i++) {
				boonja = i; boonmo = bbsum-i;
				if(start == n) break;
				else start++;
			}
		}
		System.out.println(boonja + "/" + boonmo);
	}

}
