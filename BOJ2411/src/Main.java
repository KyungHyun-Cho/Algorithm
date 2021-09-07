import java.util.*;
import java.io.*;
class Info{
	int pathCnt, itemCnt;
	Info(int itemCnt, int pathCnt){
		this.pathCnt = pathCnt;
		this.itemCnt = itemCnt;
	}
}
public class Main {
	static int[][] dir = {{0, 1}, {1, 0}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int m = stoi(inputArr[1]);
		int a = stoi(inputArr[2]);
		int b = stoi(inputArr[3]);
		int[][] map = new int[n+1][m+1];
		Info[][] dp = new Info[n+1][m+1];
		for(int i = 0; i < a; i++) {
			inputArr = br.readLine().split(" ");
			int x = stoi(inputArr[0]);
			int y = stoi(inputArr[1]);
			map[x][y] = 1;
		}
		for(int i = 0; i < b; i++) {
			inputArr = br.readLine().split(" ");
			int x = stoi(inputArr[0]);
			int y = stoi(inputArr[1]);
			map[x][y] = 2;
		}
		for(int i = 0; i <= n; i++)
			dp[i][0] = new Info(0,0);
		for(int i = 0; i <= m; i++)
			dp[0][i] = new Info(0,0);
		
		dp[1][1] = map[1][1] == 1 ? new Info(1, 1) : new Info(0, 1);
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(i == 1 && j == 1) continue;
				// 아이템이 있는 곳
				/*if(map[i][j] == 1) {
					
				}*/
				// 빈 공간인 곳
				if(map[i][j] != 2) {
					if(dp[i-1][j].itemCnt == dp[i][j-1].itemCnt) {
						dp[i][j] = new Info(dp[i-1][j].itemCnt + map[i][j], dp[i-1][j].pathCnt + dp[i][j-1].pathCnt);
					}else if(dp[i-1][j].itemCnt > dp[i][j-1].itemCnt) {
						dp[i][j] = new Info(dp[i-1][j].itemCnt + map[i][j], dp[i-1][j].pathCnt);
					}else if(dp[i-1][j].itemCnt < dp[i][j-1].itemCnt) {
						dp[i][j] = new Info(dp[i][j-1].itemCnt + map[i][j], dp[i][j-1].pathCnt);
					}else {
						//System.out.println("??");
					}
				}else
					dp[i][j] = new Info(0,0);
				
			}
		}
		System.out.println(dp[n][m].itemCnt == a ? dp[n][m].pathCnt : 0);
		
	}
	static int stoi(String str) {return Integer.parseInt(str);}

}
