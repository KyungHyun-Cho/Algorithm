import java.util.*;
public class Main {
	static int n;
	static int[][] nor_map, rg_map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		nor_map = new int[n+1][n+1];
		rg_map = new int[n+1][n+1];
		int nor_cnt = 0, rg_cnt = 0;
		for(int i = 1; i <= n; i++) {
			String str = sc.next();
			for(int j = 1; j <= str.length(); j++) {
				char code = str.charAt(j-1);
				if(code == 'R') {
					nor_map[i][j] = 0;
					rg_map[i][j] = 0;					
				}else if(code == 'G') {
					nor_map[i][j] = 1;
					rg_map[i][j] = 0;
					
				}else if(code == 'B') {
					nor_map[i][j] = 2;
					rg_map[i][j] = 2;					
				}
			}
		}
		
		visit = new boolean[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(!visit[i][j]) {
					DFS(i, j, nor_map, nor_map[i][j]);
					nor_cnt++;
				}
			}
		}
		visit = new boolean[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(!visit[i][j]) {
					DFS(i, j, rg_map, rg_map[i][j]);
					rg_cnt++;
				}
			}
		}
		System.out.println(nor_cnt + " " + rg_cnt);
	}
	
	public static void DFS(int p, int q, int[][] map, int compare) {
		visit[p][q] = true;
		for(int i = 0; i < 4; i++) {
			int new_p = p + dir[i][0];
			int new_q = q + dir[i][1];
			if(new_p > 0 && new_p <= n && new_q > 0 && new_q <= n && !visit[new_p][new_q] && map[new_p][new_q] == compare) {
				DFS(new_p, new_q, map, compare);
			}
		}
	}
}
