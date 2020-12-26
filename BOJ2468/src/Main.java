import java.util.*;
public class Main {
	static int n, max_h = -1;
	static byte[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new byte[n+1][n+1];
		
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				map[i][j] = sc.nextByte();
				max_h = map[i][j]>max_h?map[i][j]:max_h;
			}
		}
		int max_cnt = 1;
		for(int s = 1; s <= max_h; s++) {		
			visit = new boolean[n+1][n+1];
			int cnt = 0;
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(map[i][j] > s && !visit[i][j]) {
						//물에 가라앉지 않고, 방문한 적이 없는 좌표라면
						cnt++;
						DFS(i, j, s);
					}
				}
			}
			max_cnt = cnt>max_cnt?cnt:max_cnt;
		}
		System.out.println(max_cnt);
		
	}
	public static void DFS(int p, int q, int sLevel) {
		visit[p][q] = true;
		for(int i = 0; i < 4; i++) {
			int new_p = p + dir[i][0];
			int new_q = q + dir[i][1];
			if(new_p > 0 && new_p <= n && new_q > 0 && new_q <= n && !visit[new_p][new_q] && map[new_p][new_q] > sLevel)
				DFS(new_p, new_q, sLevel);			
		}
	}
}
