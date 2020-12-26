import java.util.*;
public class Main {
	static int n, l, r, move_cnt, sum, country_cnt;
	static int[][] map;
	static boolean[][] visit, visit2, possible;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		boolean isMoved = true;
		while(isMoved) {
			isMoved = false;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visit[i][j]) {
						possible = new boolean[n][n];
						DFS(i, j);
						if(country_cnt > 1) {
							//묶을 수 있는 나라가 있다면
							isMoved = true;
							int avg = sum / country_cnt;
							visit2 = new boolean[n][n];
							DFS2(i, j, avg);
						}
						country_cnt = 0;
						sum = 0;
					}
				}
			}
			if(isMoved) {
				answer++;
				visit = new boolean[n][n];
			}
		}
		System.out.println(answer);
	}
	
	public static void DFS(int x, int y) {
		visit[x][y] = true;
		possible[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int new_x = x + dir[i][0];
			int new_y = y + dir[i][1];
			if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < n) {
				//갈 수 있는곳이면
				if(!visit[new_x][new_y]) {
					//방문하지 않은 곳이면
					int dist = Math.abs(map[x][y] - map[new_x][new_y]);
					if(l <= dist && dist <= r) {
						//두 나라의 인구 차이가 l이상 r이하라면
						DFS(new_x, new_y);
					}
				}
			}
		}
		country_cnt++;
		sum += map[x][y];
	}
	
	public static void DFS2(int x, int y, int avg) {
		map[x][y] = avg;
		visit2[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int new_x = x + dir[i][0];
			int new_y = y + dir[i][1];
			if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < n) {
				//갈 수 있는곳이면
				if(!visit2[new_x][new_y] && possible[new_x][new_y]) {
					//방문한 곳이면
					DFS2(new_x, new_y, avg);
				}
			}
		}
	}
}
