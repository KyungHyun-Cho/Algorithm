import java.util.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n, m, max = Integer.MIN_VALUE;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				clearVisit();
				DFS(i, j, map[i][j], 0);
				max = Math.max(max, get_except(i, j));
			}
		}
		System.out.println(max);
	}
	public static void DFS(int x, int y, int tmp, int level) {
		visit[x][y] = true;
		if(level == 3) {
			max = Math.max(max, tmp);
		}else {
			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < m) {
					//범위 안에 있으면
					if(!visit[new_x][new_y]) {
						visit[new_x][new_y] = true;
						DFS(new_x, new_y, tmp+map[new_x][new_y], level+1);
						visit[new_x][new_y] = false;
					}
				}
			}
		}
	}
	public static int get_except(int x, int y) {
		int tmp_max = Integer.MIN_VALUE;
		for(int i = 0; i < 4; i++) {
			for(int j = i+1; j < 4; j++) {
				for(int k = j+1; k < 4; k++) {
					int tmp = map[x][y];
					int new_x1 = x + dir[i][0];
					int new_y1 = y + dir[i][1];
					int new_x2 = x + dir[j][0];
					int new_y2 = y + dir[j][1];
					int new_x3 = x + dir[k][0];
					int new_y3 = y + dir[k][1];
					if(new_x1 >= 0 && new_y1 >= 0 && new_x1 < n && new_y1 < m && new_x2 >= 0 && new_y2 >= 0 && new_x2 < n && new_y2 < m && new_x3 >= 0 && new_y3 >= 0 && new_x3 < n && new_y3 < m) {
						tmp += map[new_x1][new_y1] + map[new_x2][new_y2] + map[new_x3][new_y3];
						tmp_max = Math.max(tmp_max, tmp);
					}
				}
			}
		}
		return tmp_max;
	}
    public static void clearVisit(){
        for(boolean[] t : visit)
            Arrays.fill(t, false);
    }
}
