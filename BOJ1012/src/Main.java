import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int cnt;
	static int n, m;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int tc = 0; tc < test_case; tc++) {
			cnt = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			int k = sc.nextInt();
			map = new int[n][m];
			visit = new boolean[n][m];
			for(int i = 0; i < k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						DFS(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
				
		}
	}
	
	public static void DFS(int p, int q) {
		visit[p][q] = true;
		for(int i = 0; i < dir.length; i++) {
			int newp = p + dir[i][0];
			int newq = q + dir[i][1];
			if(newp >= 0 && newp < n && newq >= 0 && newq < m && map[newp][newq] == 1 && !visit[newp][newq]) {
				DFS(newp,newq);
			}
		}
	}
}
